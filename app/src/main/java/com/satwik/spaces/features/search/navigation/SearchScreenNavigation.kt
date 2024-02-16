package com.satwik.spaces.features.search.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.satwik.spaces.core.navigation.objects.Screen
import com.satwik.spaces.features.search.presentation.SearchScreen

fun NavGraphBuilder.searchScreen(navController: NavController){
    composable(route = Screen.Search.route) {
        SearchScreen(navController = navController)
    }
}