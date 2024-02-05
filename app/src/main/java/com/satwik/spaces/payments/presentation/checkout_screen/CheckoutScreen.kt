package com.satwik.spaces.payments.presentation.checkout_screen

import android.os.Build
import android.util.Log
import android.widget.Toast
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.firestore.CollectionReference
import com.satwik.spaces.R
import com.satwik.spaces.core.MainActivity
import com.satwik.spaces.core.components.SpacesButton
import com.satwik.spaces.core.navigation.Screen
import com.satwik.spaces.payments.presentation.checkout_screen.components.RadioListItem
import com.satwik.spaces.core.theme.Black
import com.satwik.spaces.core.theme.Purple
import com.satwik.spaces.core.theme.White
import com.satwik.spaces.core.theme.poppins
import com.satwik.spaces.core.utils.Constants
import com.satwik.spaces.core.utils.DateStore
import com.satwik.spaces.core.utils.qualifiers.BookingCollection
import com.satwik.spaces.payments.presentation.checkout_screen.components.BookingReviewSection
import com.stripe.android.PaymentConfiguration
import com.stripe.android.paymentsheet.PaymentSheet
import com.stripe.android.paymentsheet.PaymentSheetResult
import com.stripe.android.paymentsheet.rememberPaymentSheet
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

var isPaymentSuccessful = MutableStateFlow(false)

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CheckoutScreen(
    navController: NavController,
    viewModel: CheckoutScreenViewModel = hiltViewModel()
) {

    val bookingState = viewModel.bookingState.value

    val context = LocalContext.current
    val paymentsApiResponseState = viewModel.paymentsApiResponseState.value
    val paymentSheet = rememberPaymentSheet(::onPaymentSheetResult)

    val scope = rememberCoroutineScope()
    val store = DateStore(context)

    LaunchedEffect(isPaymentSuccessful) {
        scope.launch {
            isPaymentSuccessful.collect { isSuccessful ->
                if (isSuccessful) {
                    navController.navigate(Screen.PaymentConfirmationScreen.route)
                    viewModel.completeBooking()
                    isPaymentSuccessful.value = false
                }
            }
        }
    }

    val paymentSheetAppearance = PaymentSheet.Appearance(
        typography = PaymentSheet.Typography.default.copy(fontResId = R.font.poppins_light)
        )

    val address = PaymentSheet.Address(country = "IN")
    val billingDetails = PaymentSheet.BillingDetails(address = address)

        LaunchedEffect(context) {
            PaymentConfiguration.init(context, Constants.PUBLISHABLE_KEY)
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Black)
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
        ) {
            Column {

                Spacer(modifier = Modifier.height(14.dp))

                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier
                        .size(45.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_caretleft),
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

                bookingState.property?.let {
                    BookingReviewSection(
                        bookingState.property!!.name,
                        bookingState.property!!.address,
                        bookingState.property!!.imageUrls.first(),
                        bookingState.booking?.checkInDate ?: "",
                        bookingState.booking?.checkOutDate ?: "",
                        bookingState.property!!.people,
                        "USD",
                        "$" + bookingState.property!!.price
                    )
                }

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
                    icon = R.drawable.ic_creditcard,
                    text = "Credit/Debit Card",
                    selected = true
                )
                RadioListItem(icon = R.drawable.ic_wallet, text = "Wallet", selected = false)
                RadioListItem(icon = R.drawable.ic_bank, text = "Net banking", selected = false)
            }
            Column(
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                SpacesButton(
                    text = "Proceed",
                    onClick = {
                        paymentsApiResponseState.data?.let { response ->
                            val customerConfig = PaymentSheet.CustomerConfiguration(
                                id = response.customer.id,
                                ephemeralKeySecret = response.ephemeralKey.id
                            )
                            paymentSheet.presentWithPaymentIntent(
                                response.paymentIntent.client_secret,
                                PaymentSheet.Configuration(
                                    appearance = paymentSheetAppearance,
                                    merchantDisplayName = "Spaces Inc",
                                    customer = customerConfig,
                                    defaultBillingDetails = billingDetails
                                )
                            )
                        }
                    },
                    modifier = Modifier
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
    }


fun onPaymentSheetResult(paymentSheetResult: PaymentSheetResult) {

    when(paymentSheetResult) {
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



@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun CheckoutScreenPreview(){
}

