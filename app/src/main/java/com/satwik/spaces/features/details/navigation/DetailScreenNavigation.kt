package com.satwik.spaces.features.details.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.satwik.spaces.core.navigation.objects.Screen
import com.satwik.spaces.core.utils.Constants
import com.satwik.spaces.features.details.presentation.detail_screen.DetailScreen
import com.satwik.spaces.features.details.presentation.detail_screen.DetailScreenViewModel

fun NavGraphBuilder.detailScreen(navController:NavController){
    composable(
        route = Screen.Detail.route,
        arguments = listOf(navArgument(Constants.DETAIL_SCREEN_ARGUMENT_KEY){
            type = NavType.StringType
        })
    ) {
        val viewModel = hiltViewModel<DetailScreenViewModel>()
        val state = viewModel.state
        DetailScreen(navController = navController, state = state)
    }
}