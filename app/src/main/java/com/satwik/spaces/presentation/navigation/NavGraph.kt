package com.satwik.spaces.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.satwik.spaces.common.Constants
import com.satwik.spaces.presentation.detail_screen.DetailScreen
import com.satwik.spaces.presentation.home_screen.HomeScreen
import com.satwik.spaces.presentation.search_screen.SearchScreen

@Composable
fun SetupNavGraph(navController:NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(
            route = Screen.Home.route){
            HomeScreen(navController = navController)
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument(Constants.DETAIL_SCREEN_ARGUMENT_KEY){
                type = NavType.IntType
        })
        ) {
            DetailScreen()
        }

        composable(route = Screen.Search.route){
            SearchScreen(navController = navController)
        }
    }
}