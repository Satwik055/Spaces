package com.satwik.spaces.explore.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.satwik.spaces.core.navigation.objects.Screen
import com.satwik.spaces.explore.presentation.explore_screen.ExploreScreen

fun NavGraphBuilder.exploreScreen(navController:NavController){
    composable(route = Screen.Explore.route) {
        ExploreScreen(navController = navController)
    }
}