package com.satwik.spaces.explore.presentation.explore_screen.tabs.screens

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
import com.satwik.spaces.core.ui.theme.White
import com.satwik.spaces.core.ui.theme.poppins
import com.satwik.spaces.core.utils.PropertyType
import com.satwik.spaces.explore.presentation.explore_screen.components.ShimmerLoadingLayout
import com.satwik.spaces.explore.presentation.explore_screen.tabs.TabScreenViewModel
import com.satwik.spaces.explore.presentation.explore_screen.tabs.sections.NearYouSection
import com.satwik.spaces.explore.presentation.explore_screen.tabs.sections.PopularSection

@Composable
fun WorkspaceTabScreen(
    navController: NavController,
    viewModel: TabScreenViewModel = hiltViewModel(),
){

    val propertyType = PropertyType.WORKSPACE
    val state = viewModel.state.value

    LaunchedEffect(Unit){
        viewModel.getPropertiesByType(propertyType)
    }

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




