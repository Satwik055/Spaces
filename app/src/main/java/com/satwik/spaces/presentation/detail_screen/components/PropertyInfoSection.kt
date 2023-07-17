package com.satwik.spaces.presentation.detail_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satwik.spaces.R
import com.satwik.spaces.presentation.theme.Grey
import com.satwik.spaces.presentation.theme.Montserrat
import com.satwik.spaces.presentation.theme.White

@Composable
fun PropertyInfoSection(
    modifier:Modifier = Modifier,
    propertyName:String,
    propertyAddress:String,
    rating:String
){
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column{
            Text(
                text = propertyName,
                fontFamily = Montserrat,
                fontWeight = FontWeight.Normal,
                color = White,
                fontSize = 28.sp,
            )

            Row{
                Icon(
                    painter = painterResource(id = R.drawable.ic_map_pin),
                    contentDescription = null,
                    tint = Grey,
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = propertyAddress,
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.Normal,
                    color = Grey,
                    fontSize = 15.sp,
                )
            }
        }

        Rating(rating = rating)

    }

}

@Composable
fun Rating(rating:String){
    Row{
        Icon(
            painter = painterResource(id = R.drawable.ic_star),
            contentDescription = null,
            tint  = White
        )
        Text(
            text = rating,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Normal,
            color = White,
            fontSize = 18.sp,
        )
    }
}