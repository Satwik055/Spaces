package com.satwik.spaces.details.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.satwik.spaces.core.navigation.objects.Screen
import com.satwik.spaces.core.utils.Constants
import com.satwik.spaces.details.presentation.detail_screen.DetailScreen

fun NavGraphBuilder.detailScreen(navController:NavController){
    composable(
        route = Screen.Detail.route,
        arguments = listOf(navArgument(Constants.DETAIL_SCREEN_ARGUMENT_KEY){
            type = NavType.StringType
        })
    ) {
        DetailScreen(navController = navController)
    }
}