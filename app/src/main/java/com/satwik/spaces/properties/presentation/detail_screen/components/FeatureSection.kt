package com.satwik.spaces.properties.presentation.detail_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satwik.spaces.properties.presentation.theme.Grey
import com.satwik.spaces.properties.presentation.theme.Montserrat
import com.satwik.spaces.properties.presentation.theme.White


@Composable
fun FeatureSection(
    modifier:Modifier = Modifier,
    floor:String,
    people:String,
    sqft:String
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        TextBlock(
            text1 = floor,
            text2 = "Floor"
        )

        Box(modifier = Modifier
            .fillMaxHeight()
            .width(1.dp)
            .background(color = Grey)
        )

        TextBlock(
            text1 = people,
            text2 = "People"
        )

        Box(
            modifier = Modifier
            .fillMaxHeight()
            .width(1.dp)
            .background(color = Grey)
        )

        TextBlock(
            text1 = sqft,
            text2 = "Sqft"
        )
    }

}

@Composable
fun TextBlock(text1:String, text2: String){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = text1,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Normal,
            color = White,
            fontSize = 18.sp,
        )
        Text(
            text = text2,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Normal,
            color = White,
            fontSize = 18.sp,
        )
    }
}

@Preview
@Composable
fun FeatureSectionPreview(){
    FeatureSection(floor = "25th", people="5" ,sqft = "250")
}

