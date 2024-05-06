package com.satwik.checkout.presentation.checkout_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.satwik.checkout.presentation.checkout_screen.components.BookingReviewSection
import com.satwik.common.Booking
import com.satwik.common.Constants
import com.satwik.common.Screen
import com.satwik.designsystem.components.RadioListItem
import com.satwik.designsystem.components.SpacesButton
import com.satwik.designsystem.theme.Black
import com.satwik.designsystem.theme.Purple
import com.satwik.designsystem.theme.White
import com.satwik.designsystem.theme.poppins
import com.satwik.payment.domain.model.api_response.PaymentsApiResponse
import com.satwik.property.domain.model.Property
import com.stripe.android.PaymentConfiguration
import com.stripe.android.paymentsheet.PaymentSheet
import com.stripe.android.paymentsheet.PaymentSheetResult
import com.stripe.android.paymentsheet.rememberPaymentSheet
import kotlinx.coroutines.flow.MutableStateFlow

var isPaymentSuccessful = MutableStateFlow(false)

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CheckoutScreen(
    navController: NavController,
    viewModel: CheckoutScreenViewModel = hiltViewModel(),
) {

    val context = LocalContext.current
    val propertyState = viewModel.checkoutScreenUIState.value.propertyState
    val booking = viewModel.checkoutScreenUIState.value.booking
    val paymentsApiResponseState = viewModel.paymentsApiResponseState.value
    val paymentSheet = rememberPaymentSheet(::onPaymentSheetResult)

    val paymentSheetAppearance = PaymentSheet.Appearance(
        typography = PaymentSheet.Typography.default.copy(fontResId = com.satwik.designsystem.R.font.poppins_light)
    )
    val billingDetails = PaymentSheet.BillingDetails(address = PaymentSheet.Address(country = "IN"))


    LaunchedEffect(context) {
        PaymentConfiguration.init(context, Constants.PUBLISHABLE_KEY)
    }

    LaunchedEffect(isPaymentSuccessful) {
        isPaymentSuccessful.collect { isSuccessful ->
            if (isSuccessful) {
                navController.navigate(Screen.PaymentConfirmationScreen.route)
                viewModel.completeBooking()
                isPaymentSuccessful.value = false
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
    ) {
        when{
            propertyState.isLoading || paymentsApiResponseState.isLoading ->
                CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Purple
            )

            propertyState.error.isNotBlank() || paymentsApiResponseState.error.isNotBlank() ->
                Text(
                    text = when {
                        propertyState.error.isNotBlank() -> propertyState.error
                        else -> paymentsApiResponseState.error
                    },
                    style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
                    fontFamily = poppins,
                    fontWeight = FontWeight.Normal,
                    color = White,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center)
                )
            else->{
                Content(
                    navController = navController,
                    viewModel = viewModel,
                    property = propertyState.property!!,
                    booking = booking!!,
                    apiResponse = paymentsApiResponseState.data?:PaymentsApiResponse(),
                    paymentSheet = paymentSheet,
                    paymentSheetAppearance = paymentSheetAppearance,
                    billingDetails = billingDetails,
                )
            }
        }
    }
}


private fun onPaymentSheetResult(paymentSheetResult: PaymentSheetResult) {

    when (paymentSheetResult) {
        is PaymentSheetResult.Canceled -> {
            print("Canceled")
        }

        is PaymentSheetResult.Failed -> {
            print("Error: ${paymentSheetResult.error}")
        }

        is PaymentSheetResult.Completed -> {
            isPaymentSuccessful.value = true

        }
    }
}


private fun presentPaymentSheet(
    apiResponse: PaymentsApiResponse,
    paymentSheet: PaymentSheet,
    paymentSheetAppearance: PaymentSheet.Appearance,
    billingDetails: PaymentSheet.BillingDetails,
) {
    val customerConfig = PaymentSheet.CustomerConfiguration(
        id = apiResponse.customer.id,
        ephemeralKeySecret = apiResponse.ephemeralKey.id
    )

    paymentSheet.presentWithPaymentIntent(
        paymentIntentClientSecret = apiResponse.paymentIntent.client_secret,
        configuration = PaymentSheet.Configuration(
            appearance = paymentSheetAppearance,
            merchantDisplayName = "Spaces Inc",
            customer = customerConfig,
            defaultBillingDetails = billingDetails
        )

    )
}

@Composable
internal fun Content(
    navController: NavController,
    viewModel: CheckoutScreenViewModel,
    property: Property,
    booking: Booking,
    apiResponse: PaymentsApiResponse,
    paymentSheet: PaymentSheet,
    paymentSheetAppearance: PaymentSheet.Appearance,
    billingDetails: PaymentSheet.BillingDetails,
) {
    Column {

        Spacer(modifier = Modifier.height(14.dp))

        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .size(45.dp)
        ) {
            Icon(
                painter = painterResource(id = com.satwik.designsystem.R.drawable.ic_caretleft),
                contentDescription = null,
                tint = White,
                modifier = Modifier.offset(x = (-10).dp)
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "Confirm & Pay",
            fontFamily = poppins,
            fontWeight = FontWeight.Normal,
            color = White,
            style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
            fontSize = 34.sp,
        )
        Text(
            text = "proceed to continue the booking",
            fontFamily = poppins,
            fontWeight = FontWeight.Normal,
            color = White,
            fontSize = 14.sp,
            style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
        )

        Spacer(modifier = Modifier.height(40.dp))

        BookingReviewSection(
            property.name,
            property.address,
            property.imageUrls.first(),
            booking.checkInDate,
            booking.checkOutDate,
            booking.people,
            "USD",
            "$" + property.price
        )


        Spacer(modifier = Modifier.height(35.dp))

        Text(
            text = "Pay with",
            style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
            fontFamily = poppins,
            fontWeight = FontWeight.Normal,
            color = White,
            fontSize = 16.sp,
        )

        Spacer(modifier = Modifier.height(14.dp))

        RadioListItem(
            icon = com.satwik.designsystem.R.drawable.ic_creditcard,
            text = "Credit/Debit Card",
            selected = true
        )
        RadioListItem(
            icon = com.satwik.designsystem.R.drawable.ic_wallet,
            text = "Wallet",
            selected = false
        )
        RadioListItem(
            icon = com.satwik.designsystem.R.drawable.ic_bank,
            text = "Net banking",
            selected = false
        )

        Spacer(modifier = Modifier.weight(1f))
        SpacesButton(
            text = "Proceed",
            modifier = Modifier,
            onClick = {
                viewModel.initiatePaymentRequest(property.price)
                presentPaymentSheet(
                    apiResponse = apiResponse,
                    paymentSheet = paymentSheet,
                    paymentSheetAppearance = paymentSheetAppearance,
                    billingDetails = billingDetails,
                )
            },
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "By making the payment you agree our Privacy Policy and Terms and Conditions",
            fontFamily = poppins,
            fontWeight = FontWeight.Medium,
            color = White,
            lineHeight = 12.sp,
            fontSize = 10.sp,
        )
    }

}






