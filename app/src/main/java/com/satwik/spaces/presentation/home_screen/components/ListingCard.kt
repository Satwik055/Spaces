package com.satwik.spaces.presentation.home_screen.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.satwik.spaces.R
import com.satwik.spaces.domain.model.Property
import com.satwik.spaces.presentation.theme.Montserrat
import com.satwik.spaces.presentation.theme.Purple
import com.satwik.spaces.presentation.theme.White


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListingCard(
    modifier:Modifier = Modifier,
    propertyName:String,
    propertyAddress:String,
    imageUrl:String,
    onClick: () -> Unit
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

            SubcomposeAsyncImage(
                model = imageUrl,
                contentScale = ContentScale.Crop,
                loading = { CircularProgressIndicator(color= Purple, modifier = Modifier.height(40.dp).width(10.dp)) },
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
                    fontFamily = Montserrat,
                    fontWeight = FontWeight(400),
                    color = White,
                    fontSize = 20.sp,
                )
                Text(
                    text = propertyAddress,
                    fontFamily = Montserrat,
                    fontWeight = FontWeight(400),
                    color = White,
                    fontSize = 11.sp,
                )
            }
        }

    }

}



@Preview
@Composable
fun SpacesCardPreview(){

}
