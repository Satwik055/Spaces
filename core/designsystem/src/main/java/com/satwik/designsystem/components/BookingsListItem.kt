package com.satwik.designsystem.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.satwik.designsystem.R
import com.satwik.designsystem.theme.Grey
import com.satwik.designsystem.theme.White


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
            .border(1.dp, Grey, RoundedCornerShape(10.dp)).padding(10.dp)
    ) {

        AsyncImage(
            model = thumbnailURL,
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = modifier.size(60.dp)
        )


        Spacer(modifier = Modifier.width(10.dp))
        Column {

            BookingDates(checkinDate = checkinDate, checkoutDate = checkoutDate)
            Text(text = propertyName, color = White)
            Text(text = propertyAddress, color = White)
        }

        IconButton(
            onClick = onClick,
            modifier = Modifier.size(30.dp).align(Alignment.CenterVertically)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_caretleft),
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
        Text(text = checkinDate, color = White)
        Text(text = appendedCheckoutDate, color = White)
    }
}