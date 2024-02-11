package com.satwik.spaces.explore.presentation.explore_screen.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satwik.spaces.R
import com.satwik.spaces.core.ui.theme.Purple
import com.satwik.spaces.core.ui.theme.White
import com.satwik.spaces.core.ui.theme.poppins

@Composable
fun TopAppBar(
    currentCity:String,
    currentState:String,
    modifier: Modifier = Modifier,
    @DrawableRes
    navDrawerIcon:Int = R.drawable.ic_hamburger,
    @DrawableRes
    searchIcon:Int = R.drawable.ic_search,
    iconSize: Dp = 28.dp,
    searchOnClick:() -> Unit,
    locationOnClick:() -> Unit,
    navDrawerOnClick:() -> Unit

){
    Box(
        modifier = modifier.fillMaxWidth()
    ){
        IconButton(onClick =  navDrawerOnClick ,

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

        IconButton(onClick = searchOnClick,
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
            modifier =  Modifier.align(Alignment.TopCenter).offset(x= (-40).dp),
            state = currentState,
            city= currentCity,
            onClick = locationOnClick
        )

    }

}

@Composable
fun CurrentLocation(
    modifier:Modifier = Modifier,
    onClick:() -> Unit,
    city:String,
    state:String,
    @DrawableRes
    mapPinIcon:Int = R.drawable.ic_map_pin
){
    Row(
        modifier = modifier.clickable {onClick.invoke()},
        verticalAlignment = Alignment.CenterVertically,
    ){
        Icon(
            painter = painterResource(id = mapPinIcon ),
            contentDescription = null,
            tint = White

        )
        Spacer(modifier=  Modifier.width(10.dp))
        Column{
            Text(
                text = state,
                style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
                fontFamily = poppins,
                fontWeight = FontWeight.Light,
                fontSize = 13.sp,
                color = White
            )
            Text(
                text = city,
                style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
                fontWeight = FontWeight.Light,
                fontFamily = poppins,
                fontSize = 13.sp,
                color = Purple
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF090909)
@Composable
fun TopAppBarPreview() {
    TopAppBar(
        modifier = Modifier.padding(5.dp),
        currentCity = "New York",
        currentState = "Lower Manhattan",
        searchOnClick = { /*TODO*/ },
        locationOnClick = { /*TODO*/ }) {
        
    }
}