package com.satwik.spaces.core.components

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satwik.spaces.core.theme.Grey
import com.satwik.spaces.core.theme.Montserrat
import com.satwik.spaces.core.theme.White

@Composable
fun InfoCard(
    title:String,
    content:String
){
    Card(
        border = BorderStroke(1.dp, Grey),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        shape = RoundedCornerShape(8.dp)
    ){
        Column (
            modifier = Modifier.padding(15.dp)
        ){
            Text(
                text =  title,
                fontFamily = Montserrat,
                fontWeight = FontWeight.Medium,
                color = White,
                fontSize = 16.sp,
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = content,
                fontFamily = Montserrat,
                fontWeight = FontWeight.Normal,
                color = White,
                fontSize = 13.sp,
            )
        }
    }
}