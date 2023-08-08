package com.satwik.spaces.presentation.home_screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.satwik.spaces.common.Constants
import com.satwik.spaces.common.DummyApi
import com.satwik.spaces.domain.model.Property
import com.satwik.spaces.presentation.home_screen.components.ListingCard
import com.satwik.spaces.presentation.home_screen.components.TopAppBar
import com.satwik.spaces.presentation.navigation.Screen
import com.satwik.spaces.presentation.theme.Black
import com.satwik.spaces.presentation.theme.Montserrat
import com.satwik.spaces.presentation.theme.White
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.tasks.await


@Composable
fun HomeScreen(
    navController:NavController,
    viewModel:HomeScreenViewModel = hiltViewModel()
){

    val state = viewModel.state.value

    Column  (
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
            .padding(start = 8.dp, end = 8.dp)
    ){
        Spacer(modifier = Modifier.height(10.dp))

        TopAppBar(searchOnClick = {navController.navigate(Screen.Search.route)})

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Explore a suitable workplace for you",
            fontFamily = Montserrat,
            fontWeight = FontWeight.Normal,
            color = White,
            fontSize = 34.sp,
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Popular",
            fontFamily = Montserrat,
            fontWeight = FontWeight.Normal,
            color = White,
            fontSize = 16.sp,
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){items(state.properties){
            ListingCard(
                propertyName = it.name,
                propertyAddress = it.address,
                imageUrl = it.imageUrls.first(),
                onClick = { navController.navigate(Screen.Detail.passId(it.id))}
            )
        }
        }

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Near You",
            fontFamily = Montserrat,
            fontWeight = FontWeight.Normal,
            color = White,
            fontSize = 16.sp,
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){items(state.properties){
            ListingCard(
                propertyName = it.name,
                propertyAddress = it.address,
                imageUrl = it.imageUrls.first(),
                onClick = { navController.navigate(Screen.Detail.passId(it.id))},
                modifier = Modifier
                    .height(204.dp)
                    .width(380.dp)
            )
        }
        }


    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(navController = rememberNavController())
}