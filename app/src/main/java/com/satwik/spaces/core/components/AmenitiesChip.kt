package com.satwik.spaces.core.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satwik.spaces.core.theme.DarkGrey
import com.satwik.spaces.core.theme.Montserrat
import com.satwik.spaces.core.theme.White

@Composable
fun AmenitiesChip(
    name:String,
    @DrawableRes
    icon:Int
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(color = DarkGrey, shape = RoundedCornerShape(5.dp))
            .padding(7.dp)
    ){
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint  = White,
            modifier = Modifier.size(22.dp)
        )
        Spacer(modifier = Modifier.width(7.dp))
        Text(
            text = name,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Normal,
            color = White,
            fontSize = 13.sp,
        )
    }
}