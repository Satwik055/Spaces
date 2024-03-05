package com.satwik.checkout.presentation.checkout_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.satwik.designsystem.theme.Grey
import com.satwik.designsystem.theme.White
import com.satwik.designsystem.theme.poppins


@Composable
fun BookingReviewSection(
    name:String,
    address:String,
    thumbnailUrl:String,
    startDate:String,
    endDate:String,
    people:String,
    currency:String,
    price:String
){
    Column(
        modifier = Modifier
            .border(1.dp, Grey, RoundedCornerShape(10.dp))
    ) {
        NameSection(
            name = name,
            address = address,
            thumbnailUrl = thumbnailUrl
        )
        HorizontalDivider(thickness = 1.dp, color = Grey)
        DateSection(
            startDate = startDate,
            endDate = endDate,
            people = people
        )
        HorizontalDivider(thickness = 1.dp, color = Grey)
        Spacer(modifier = Modifier.height(5.dp))
        PriceSection(
            currency = currency,
            price = price
        )
    }
}

@Composable
fun NameSection(
    modifier:Modifier = Modifier,
    name:String,
    address:String,
    thumbnailUrl:String
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column {
            Text(
                text = name,
                fontFamily = poppins,
                fontWeight = FontWeight.Medium,
                color = White,
                fontSize = 17.sp,
                style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),

                )
            Text(
                text = address,
                fontFamily = poppins,
                style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
                fontWeight = FontWeight.Medium,
                color = Grey,
                fontSize = 14.sp,
            )
        }
        SubcomposeAsyncImage(
            model = thumbnailUrl,
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .height(72.dp)
                .width(52.dp)
        )
    }
}

@Composable
fun DateSection(
    startDate:String,
    endDate:String,
    people:String,
    modifier:Modifier = Modifier,
    ){
    Column(
        modifier = modifier.padding(15.dp)
    ) {
        Box (
            modifier = Modifier.fillMaxWidth()
        ){
            Row(
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Image(
                    painter = painterResource(id = com.satwik.designsystem.R.drawable.ic_clock),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = startDate,
                    fontFamily = poppins,
                    fontWeight = FontWeight.Medium,
                    color = White,
                    style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
                    fontSize = 14.sp,
                )
            }

            Image(
                painter = painterResource(id = com.satwik.designsystem.R.drawable.ic_arrowright),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(20.dp)
            )

            Text(
                text = endDate,
                fontFamily = poppins,
                fontWeight = FontWeight.Medium,
                color = White,
                style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
                fontSize = 14.sp,
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))


        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = com.satwik.designsystem.R.drawable.ic_users), contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "$people people",
                fontFamily = poppins,
                style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
                fontWeight = FontWeight.Medium,
                color = White,
                fontSize = 14.sp,
            )
        }
    }
}

@Composable
fun PriceSection(
    currency:String,
    price:String,
    modifier: Modifier = Modifier
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.padding(15.dp).fillMaxWidth()
    ){
        Text(
            text = "Total($currency)",
            fontFamily = poppins,
            fontWeight = FontWeight.SemiBold,
            color = White,
            style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
            fontSize = 16.sp,
        )

        Text(
            text = price,
            fontFamily = poppins,
            fontWeight = FontWeight.SemiBold,
            color = White,
            style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
            fontSize = 16.sp,
        )
    }

}

@Preview(showBackground = true)
@Composable
fun BookingReviewPreview(){
    BookingReviewSection(
        "Sunny Meadows",
        "2455 Ave, South Park, NY",
        "https://penkethgroup.com/wp-content/uploads/2022/09/ombudsman-carousel.jpg",
        "24 Mar 2023",
        "25 Mar 2023",
        "5",
        "USD",
        "$799.99"
    )
}