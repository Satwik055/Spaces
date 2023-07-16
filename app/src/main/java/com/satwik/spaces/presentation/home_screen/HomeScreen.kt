package com.satwik.spaces.presentation.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satwik.spaces.R
import com.satwik.spaces.presentation.home_screen.components.TopAppBar
import com.satwik.spaces.presentation.theme.Black
import com.satwik.spaces.presentation.theme.Montserrat
import com.satwik.spaces.presentation.theme.Purple
import com.satwik.spaces.presentation.theme.White


@Composable
fun HomeScreen(){
    Column  (
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
            .padding(start = 8.dp, end = 8.dp)
    ){
        TopAppBar()

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Explore a suitable workplace for you",
            fontFamily = Montserrat,
            fontWeight = FontWeight(400),
            color = White,
            fontSize = 34.sp,
        )
    }
}





@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}