package com.satwik.spaces.presentation.home_screen.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satwik.spaces.R
import com.satwik.spaces.presentation.theme.Montserrat
import com.satwik.spaces.presentation.theme.Purple
import com.satwik.spaces.presentation.theme.White

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    @DrawableRes
    navDrawerIcon:Int = R.drawable.ic_hamburger,
    @DrawableRes
    searchIcon:Int = R.drawable.ic_search,
    iconSize: Dp = 28.dp
){
    Box(
        modifier = modifier.fillMaxWidth()
    ){
        IconButton(onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.CenterStart)
                .size(iconSize)
        ) {
            Icon(
                painter = painterResource(id = navDrawerIcon),
                contentDescription = null,
                tint = White,

            )
        }

        IconButton(onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(iconSize)
        ) {
            Icon(
                painter = painterResource(id = searchIcon),
                contentDescription = null,
                tint = White,

            )
        }
        CurrentLocation(
            modifier =  Modifier.align(Alignment.TopCenter),
            area = "Lower Manhattan",
            city= "New York"
        )

    }

}

@Composable
fun CurrentLocation(
    modifier:Modifier = Modifier,
    city:String,
    area:String,
    @DrawableRes
    mapPinIcon:Int = R.drawable.ic_map_pin
){
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            painter = painterResource(id = mapPinIcon ),
            contentDescription = null,
            tint = White

        )
        Spacer(modifier=  Modifier.width(10.dp))
        Column{
            Text(
                text = area,
                fontFamily = Montserrat,
                fontWeight = FontWeight.Normal,
                color = White,
                fontSize = 14.sp,
            )
            Text(
                text = city,
                fontFamily = Montserrat,
                fontWeight = FontWeight.Normal,
                color = Purple,
                fontSize = 14.sp,
            )
        }

    }
}