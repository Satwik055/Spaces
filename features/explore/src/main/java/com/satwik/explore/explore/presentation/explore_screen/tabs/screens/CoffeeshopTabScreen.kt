package com.satwik.explore.explore.presentation.explore_screen.tabs.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.satwik.common.PropertyType
import com.satwik.designsystem.theme.White
import com.satwik.designsystem.theme.poppins
import com.satwik.explore.explore.presentation.explore_screen.components.ShimmerLoadingLayout
import com.satwik.explore.explore.presentation.explore_screen.tabs.TabScreenViewModel
import com.satwik.explore.explore.presentation.explore_screen.tabs.sections.NearYouSection
import com.satwik.explore.explore.presentation.explore_screen.tabs.sections.PopularSection

@Composable
fun CoffeeshopTabScreen(
    navController: NavController,
    viewModel: TabScreenViewModel = hiltViewModel(),
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
                fontFamily = poppins,
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