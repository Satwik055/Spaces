package com.satwik.detail.presentation.detail_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satwik.designsystem.components.SpacesButton
import com.satwik.designsystem.theme.Black
import com.satwik.designsystem.theme.Grey
import com.satwik.designsystem.theme.White
import com.satwik.designsystem.theme.poppins

@Composable
fun BottomBarSection(
    price:String,
    modifier:Modifier = Modifier,
    onClick: () -> Unit
){
    Box (
        modifier = modifier
            .fillMaxWidth()
            .background(color = Black)

    ){
        HorizontalDivider(
            modifier = Modifier.align(Alignment.TopCenter),
            thickness = 1.dp,
            color = Grey
        )
        Text(
            text = price,
            fontFamily = poppins,
            style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
            fontWeight = FontWeight.Normal,
            color = White,
            fontSize = 17.sp,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 16.dp)
        )

        SpacesButton(
            text = "Book Now",
            onClick = { onClick.invoke()},
            fontSize = 16.sp,
            modifier = Modifier
                .width(188.dp)
                .align(Alignment.CenterEnd)
                .padding(top = 10.dp, bottom = 10.dp, end = 16.dp)
        )
    }
}