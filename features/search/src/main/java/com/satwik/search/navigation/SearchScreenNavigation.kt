package com.satwik.search.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.satwik.common.Screen
import com.satwik.search.presentation.SearchScreen

fun NavGraphBuilder.searchScreen(navController: NavController){
    composable(route = Screen.Search.route) {
        SearchScreen(navController = navController)
    }
}