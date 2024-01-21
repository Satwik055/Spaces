package com.satwik.spaces.properties.presentation.detail_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satwik.spaces.R
import com.satwik.spaces.core.theme.DarkGrey
import com.satwik.spaces.core.theme.Grey
import com.satwik.spaces.core.theme.poppins
import com.satwik.spaces.core.theme.White

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
                style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
                fontFamily = poppins,
                fontWeight = FontWeight.W300,
                color = White,
                fontSize = 26.sp,
            )

            Row{
                Icon(
                    painter = painterResource(id = R.drawable.ic_map_pin),
                    contentDescription = null,
                    tint = Grey,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = modifier.width(3.dp))
                Text(
                    text = propertyAddress,
                    style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
                    fontFamily = poppins,
                    fontWeight = FontWeight.W300,
                    color = Grey,
                    fontSize = 13.sp,
                )
            }
        }

        Rating(rating = rating)

    }

}

@Composable
fun Rating(rating:String){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.background(color = DarkGrey, shape = RoundedCornerShape(5.dp)).padding(7.dp)
    ){
        Icon(
            painter = painterResource(id = R.drawable.ic_star),
            contentDescription = null,
            tint  = White
        )
        Spacer(modifier = Modifier.width(7.dp))
        Text(
            text = rating,
            fontFamily = poppins,
            style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
            fontWeight = FontWeight.Light,
            color = White,
            fontSize = 16.sp,
        )
    }
}