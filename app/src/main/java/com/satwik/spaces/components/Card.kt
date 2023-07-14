package com.satwik.spaces.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import com.satwik.spaces.ui.theme.Black
import com.satwik.spaces.ui.theme.Montserrat


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
                .padding(7.dp),
        ){
            Column(
                modifier = Modifier.align(Alignment.BottomStart)
            ) {
                Text(
                    text = "Cleo Cave",
                    fontFamily = Montserrat,
                    fontWeight = FontWeight(400),
                    color = Black,
                    fontSize = 20.sp
                )
                Text(
                    text = "323 Maple street, NY",
                    fontFamily = Montserrat,
                    fontWeight = FontWeight(400),
                    color = Black,
                    fontSize = 11.sp
                )
            }
        }
        ImageWithOverlay()

    }
}

@Composable
fun ImageWithOverlay(){
   Box(
       modifier = Modifier
           .fillMaxSize()
           .background(
               brush = Brush.verticalGradient(
                   colors = listOf(Color.Transparent, Black)
               )
           )
   )
    Image(
        modifier= Modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.office_int),
        contentDescription = null
    )


}


@Preview
@Composable
fun SpacesCardPreview(){
    SpacesCard()
}
