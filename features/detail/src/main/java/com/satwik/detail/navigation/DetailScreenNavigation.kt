package com.satwik.detail.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.satwik.common.Constants
import com.satwik.common.Screen
import com.satwik.detail.presentation.detail_screen.DetailScreen
import com.satwik.detail.presentation.detail_screen.DetailScreenViewModel

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