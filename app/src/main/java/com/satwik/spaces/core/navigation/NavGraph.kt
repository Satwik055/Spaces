package com.satwik.spaces.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.satwik.spaces.authentication.presentation.login_screen.LoginScreen
import com.satwik.spaces.authentication.presentation.signup_screen.SignUpScreen
import com.satwik.spaces.payments.presentation.confirmation_screen.ConfirmationScreen
import com.satwik.spaces.properties.common.Constants
import com.satwik.spaces.properties.presentation.detail_screen.DetailScreen
import com.satwik.spaces.properties.presentation.home_screen.HomeScreen
import com.satwik.spaces.properties.presentation.search_screen.SearchScreen


@Composable
fun SetupNavGraph(navController:NavHostController){

    var startDestination by remember { mutableStateOf("") }

    if (Firebase.auth.currentUser != null){
        startDestination = Screen.Home.route
    }
    else{
        startDestination = Screen.Signup.route
    }

    NavHost(
        navController = navController,
        startDestination = startDestination
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
            DetailScreen(navController = navController)
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

        composable(route= Screen.Confirmation.route){
            ConfirmationScreen(navController=navController)
        }
    }
}
