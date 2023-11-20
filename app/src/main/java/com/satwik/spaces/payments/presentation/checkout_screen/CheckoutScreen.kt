package com.satwik.spaces.payments.presentation.checkout_screen

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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.satwik.spaces.R
import com.satwik.spaces.core.components.SpacesButton
import com.satwik.spaces.payments.presentation.checkout_screen.components.RadioListItem
import com.satwik.spaces.core.theme.Black
import com.satwik.spaces.core.theme.Montserrat
import com.satwik.spaces.core.theme.White
import com.satwik.spaces.payments.presentation.checkout_screen.components.BookingReviewSection

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CheckoutScreen(
    navController: NavController,
    viewModel: CheckoutScreenViewModel = hiltViewModel()
){
    val propertyState = viewModel.propertyState.value
    val bookingInfoState = viewModel.bookingInfoState.value

    Box (
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
                    modifier = Modifier.offset(x= (-10).dp)
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Confirm & Pay",
                fontFamily = Montserrat,
                fontWeight = FontWeight.Normal,
                color = White,
                fontSize = 34.sp,
            )
            Text(
                text = "proceed to continue the booking",
                fontFamily = Montserrat,
                fontWeight = FontWeight.Normal,
                color = White,
                fontSize = 16.sp,
            )

            Spacer(modifier = Modifier.height(40.dp))

            propertyState.property?.let {
                BookingReviewSection(
                    name = propertyState.property.name,
                    address = propertyState.property.address,
                    thumbnailUrl = propertyState.property.imageUrls.first(),
                    startDate = bookingInfoState.startDate.toString(),
                    endDate = bookingInfoState.endDate.toString(),
                    people = bookingInfoState.people.toString(),
                    currency = "USD",
                    price = "$" + propertyState.property.price
                )
            }

            Spacer(modifier = Modifier.height(35.dp))

            Text(
                text = "Pay with",
                fontFamily = Montserrat,
                fontWeight = FontWeight.Normal,
                color = White,
                fontSize = 16.sp,
            )

            Spacer(modifier = Modifier.height(14.dp))

            RadioListItem(icon = R.drawable.ic_creditcard, text = "Credit/Debit Card", selected = true)
            RadioListItem(icon = R.drawable.ic_wallet, text = "Wallet", selected = true)
            RadioListItem(icon = R.drawable.ic_bank, text = "Net banking", selected = true)
        }
        Column(
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            SpacesButton(
                text = "Proceed",
                onClick = { TODO() },
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "By making the payment you agree our Privacy Policy and Terms and Conditions",
                fontFamily = Montserrat,
                fontWeight = FontWeight.Medium,
                color = White,
                lineHeight = 12.sp,
                fontSize = 10.sp,
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun CheckoutScreenPreview(){
    CheckoutScreen(navController = rememberNavController())
}







