package com.satwik.explore.explore.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.satwik.common.Screen
import com.satwik.explore.explore.presentation.explore_screen.ExploreScreen

fun NavGraphBuilder.exploreScreen(navController:NavController){
    composable(route = Screen.Explore.route) {
        ExploreScreen(navController = navController)
    }
}