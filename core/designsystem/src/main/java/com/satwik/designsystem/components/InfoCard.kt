package com.satwik.designsystem.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satwik.designsystem.theme.Grey
import com.satwik.designsystem.theme.White
import com.satwik.designsystem.theme.poppins

@Composable
fun InfoCard(
    title:String,
    content:String
){
    Card(
        border = BorderStroke(Dp.Hairline, Grey),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        shape = RoundedCornerShape(8.dp)
    ){
        Column (
            modifier = Modifier.padding(13.dp)
        ){
            Text(
                text =  title,
                fontFamily = poppins,
                style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
                fontWeight = FontWeight.Normal,
                color = White,
                fontSize = 16.sp,
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = content,
                fontFamily = poppins,
                fontWeight = FontWeight.Light,
                style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
                color = White,
                fontSize = 13.sp,
            )
        }
    }
}