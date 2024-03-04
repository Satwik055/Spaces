package com.satwik.designsystem.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.satwik.designsystem.theme.White
import com.satwik.designsystem.theme.poppins


@Composable
fun ListingCard(
    modifier:Modifier = Modifier,
    propertyName:String,
    propertyAddress:String,
    imageUrl:String,
    onClick: () -> Unit,
    titleFontSize:TextUnit = 20.sp,
    addressFontSize:TextUnit = 11.sp
){
    Surface(
        shape = RoundedCornerShape(10.dp),
        onClick = onClick,
        modifier = modifier
            .height(173.dp)
            .width(287.dp),
        shadowElevation = 10.dp,
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
        ){

            AsyncImage(
                model = imageUrl,
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier.matchParentSize()
            )

            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(
                        brush = Brush.verticalGradient(
                            0.6f to Color.Transparent,
                            1f to Color.Black
                        )
                    )
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 7.dp, bottom = 7.dp)
            ) {
                Text(
                    text = propertyName,
                    style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
                    fontFamily = poppins,
                    fontWeight = FontWeight.Light,
                    color = White,
                    fontSize = titleFontSize,
                )
                Text(
                    text = propertyAddress,
                    style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
                    fontFamily = poppins,
                    fontWeight = FontWeight.Light,
                    color = White,
                    fontSize = addressFontSize,
                )
            }
        }
    }
}



@Preview
@Composable
fun SpacesCardPreview(){
    ListingCard(
        propertyName = "Cleo County",
        propertyAddress = "233 Ave St. Central park, NY 31091",
        imageUrl = "https://img.freepik.com/premium-photo/3d-rendering-modern-luxury-home-interior_674881-465.jpg?size=626&ext=jpg&ga=GA1.1.1826414947.1699401600&semt=ais",
        onClick = { /*TODO*/ })
}
