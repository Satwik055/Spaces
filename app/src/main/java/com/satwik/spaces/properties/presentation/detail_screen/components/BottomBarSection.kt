package com.satwik.spaces.properties.presentation.detail_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satwik.spaces.core.components.SpacesButton
import com.satwik.spaces.core.theme.Black
import com.satwik.spaces.core.theme.Grey
import com.satwik.spaces.core.theme.Montserrat
import com.satwik.spaces.core.theme.White

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
        Divider(
            color = Grey,
            thickness = 1.dp,
            modifier = Modifier.align(Alignment.TopCenter)
        )
        Text(
            text = price,
            fontFamily = Montserrat,
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
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .width(188.dp)
                .align(Alignment.CenterEnd)
                .padding(top = 10.dp, bottom = 10.dp, end = 16.dp)
        )
    }
}