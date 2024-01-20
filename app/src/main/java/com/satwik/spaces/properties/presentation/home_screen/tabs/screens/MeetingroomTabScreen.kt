package com.satwik.spaces.properties.presentation.home_screen.tabs.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.satwik.spaces.core.navigation.Screen
import com.satwik.spaces.core.theme.Montserrat
import com.satwik.spaces.core.theme.White
import com.satwik.spaces.properties.presentation.home_screen.components.ShimmerLoadingLayout
import com.satwik.spaces.core.components.ListingCard
import com.satwik.spaces.core.utils.PropertyType
import com.satwik.spaces.properties.presentation.home_screen.tabs.TabScreenViewModel
import com.satwik.spaces.properties.presentation.home_screen.tabs.sections.NearYouSection
import com.satwik.spaces.properties.presentation.home_screen.tabs.sections.PopularSection

@Composable
fun MeetingroomTabScreen(
    navController: NavController,
    viewModel: TabScreenViewModel = hiltViewModel()
){

    LaunchedEffect(Unit){
        viewModel.getPropertiesByType(PropertyType.WORKSPACE)
    }

    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){

        if(state.isLoading){
            ShimmerLoadingLayout()
        }

        if(state.error.isNotBlank()) {
            Text(
                text = state.error,
                fontFamily = Montserrat,
                fontWeight = FontWeight.Normal,
                color = White,
                fontSize = 20.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }



        if(state.properties.isNotEmpty()){
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ){
                item {
                    PopularSection(properties = state.properties, navController = navController)
                }
                NearYouSection(properties = state.properties, navController = navController)
            }
        }
    }
}