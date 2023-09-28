package com.satwik.spaces.payments.presentation.confirmation_screen

import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.satwik.spaces.R
import com.satwik.spaces.core.components.SpacesButton
import com.satwik.spaces.payments.presentation.confirmation_screen.components.DetailSection
import com.satwik.spaces.payments.presentation.confirmation_screen.components.RadioListItem
import com.satwik.spaces.properties.presentation.theme.Black
import com.satwik.spaces.properties.presentation.theme.Grey
import com.satwik.spaces.properties.presentation.theme.Montserrat
import com.satwik.spaces.properties.presentation.theme.White
import java.nio.file.WatchEvent

@Composable
fun ConfirmationScreen(
    navController: NavController
){
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
    ) {
        Column {

            Spacer(modifier = Modifier.height(14.dp))

            IconButton(
                onClick = { /*TODO*/ },
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

            DetailSection(
                "Sunny Meadows",
                "2455 Ave, South Park, NY",
                R.drawable.office_int,
                "24 Mar 2023",
                "25 Mar 2023",
                "5",
                "USD",
                "$799.99"
            )
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

@Preview
@Composable
fun ConfirmationScreenPreview(){
    ConfirmationScreen(navController = rememberNavController())
}








