package com.satwik.spaces.presentation.detail_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satwik.spaces.R
import com.satwik.spaces.presentation.detail_screen.components.FeatureSection
import com.satwik.spaces.presentation.detail_screen.components.PropertyInfoSection
import com.satwik.spaces.presentation.theme.Black
import com.satwik.spaces.presentation.theme.Grey
import com.satwik.spaces.presentation.theme.Montserrat
import com.satwik.spaces.presentation.theme.White

@Composable
fun DetailScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Black)
            .padding(start = 8.dp, end = 8.dp)
    ) {
        PropertyInfoSection(propertyName = "Binari Greenwich", propertyAddress = "232 Maple Street, New York", rating = "5.0")

        Spacer(modifier = Modifier.height(30.dp))

        FeatureSection(floor = "25th", people="5" ,sqft = "250")

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Description",
            fontFamily = Montserrat,
            fontWeight = FontWeight.Normal,
            color = White,
            fontSize = 20.sp,
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "This is description, the property poster is supposed to write something here and fill this nigga up",
            fontFamily = Montserrat,
            fontWeight = FontWeight.Normal,
            color = White,
            fontSize = 15.sp,
        )



    }
}



@Preview
@Composable
fun DetailScreenPreview(){
    DetailScreen()
}