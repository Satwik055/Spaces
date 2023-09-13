package com.satwik.spaces.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.satwik.spaces.authentication.presentation.login_screen.LoginScreen
import com.satwik.spaces.authentication.presentation.signup_screen.SignUpScreen
import com.satwik.spaces.properties.common.Constants
import com.satwik.spaces.properties.presentation.detail_screen.DetailScreen
import com.satwik.spaces.properties.presentation.home_screen.HomeScreen
import com.satwik.spaces.properties.presentation.search_screen.SearchScreen

@Composable
fun SetupNavGraph(navController:NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ){
        composable(
            route = Screen.Home.route){
            HomeScreen(navController = navController)
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument(Constants.DETAIL_SCREEN_ARGUMENT_KEY){
                type = NavType.StringType
        })
        ) {
            DetailScreen()
        }

        composable(route = Screen.Search.route){
            SearchScreen(navController = navController)
        }

        composable(route = Screen.Signup.route){
            SignUpScreen(navController = navController)
        }

        composable(route = Screen.Login.route){
            LoginScreen(navController = navController)
        }
    }
}