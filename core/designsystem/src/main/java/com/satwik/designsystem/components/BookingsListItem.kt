package com.satwik.designsystem.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satwik.designsystem.R
import com.satwik.designsystem.theme.Grey
import com.satwik.designsystem.theme.White
import com.satwik.designsystem.theme.poppins


@Composable
fun BookingsListItem(
    modifier: Modifier = Modifier,
    propertyName: String,
    propertyAddress: String,
    thumbnailURL: String,
    checkinDate: String,
    checkoutDate: String,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .height(80.dp)
            .border(1.dp, Grey, RoundedCornerShape(10.dp))
            .padding(10.dp)
    ) {

//        AsyncImage(
//            model = thumbnailURL,
//            contentDescription = null,
//            modifier = modifier.size(20.dp)
//        )

        Spacer(modifier = Modifier.width(10.dp))

        Column {
            BookingDates(checkinDate = checkinDate, checkoutDate = checkoutDate)
            Text(
                text = propertyName,
                color = White,
                fontFamily= poppins,
                fontSize = 16.sp,
                style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
            )
            Text(
                text = propertyAddress,
                color = White,
                fontFamily= poppins,
                fontSize = 12.sp,
                style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
            )
        }


        IconButton(
            onClick = onClick,
            modifier = Modifier
                .size(30.dp)
                .align(Alignment.CenterVertically)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_caretleft),
                modifier = Modifier.rotate(180f),
                contentDescription = null,
                tint = White
            )
        }
    }
}


@Composable
fun BookingDates(
    checkinDate: String,
    checkoutDate: String,
) {
    val appendedCheckoutDate = buildAnnotatedString {
        append(" - ")
        append(checkoutDate)
    }

    Row {
        Text(
            text = checkinDate,
            color = Grey,
            fontSize = 12.sp,
            fontFamily= poppins,
            style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
            )
        Text(
            text = appendedCheckoutDate,
            color = Grey,
            fontSize = 12.sp,
            fontFamily= poppins,
            style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
            )
    }
}

@Preview
@Composable
private fun Preview(){
    BookingsListItem(
        propertyName = "sdfsf",
        propertyAddress = "sfdsfs",
        thumbnailURL = "ewrewrew",
        checkinDate = "aeresr",
        checkoutDate = "sefesr",
        onClick = {/*TODO*/ }
    )
}