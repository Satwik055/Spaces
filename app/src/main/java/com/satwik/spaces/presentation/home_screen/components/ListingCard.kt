package com.satwik.spaces.presentation.home_screen.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satwik.spaces.R
import com.satwik.spaces.presentation.theme.Montserrat
import com.satwik.spaces.presentation.theme.White


@Composable
fun SpacesCard(){
    Card(shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .height(173.dp)
            .width(287.dp),
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
        ){
            val painter = painterResource(id = R.drawable.office_int)
            Image(
                painter = painter,
                modifier = Modifier
                    .matchParentSize()
                    .aspectRatio(painter.intrinsicSize.width / painter.intrinsicSize.height),
                contentDescription = null
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
                modifier = Modifier.align(Alignment.BottomStart)
                    .padding(start = 7.dp, bottom = 7.dp)
            ) {
                Text(
                    text = "Cleo Cave",
                    fontFamily = Montserrat,
                    fontWeight = FontWeight(400),
                    color = White,
                    fontSize = 20.sp,
                )
                Text(
                    text = "323 Maple street, NY",
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
    SpacesCard()
}
