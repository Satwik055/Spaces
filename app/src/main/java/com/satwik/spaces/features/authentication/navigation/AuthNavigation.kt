package com.satwik.spaces.features.authentication.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.satwik.spaces.core.navigation.objects.Graph
import com.satwik.spaces.core.navigation.objects.Screen
import com.satwik.spaces.features.authentication.presentation.login_screen.LoginScreen
import com.satwik.spaces.features.authentication.presentation.signup_screen.SignUpScreen

fun NavGraphBuilder.authGraph(navController:NavController){
    navigation(
        route = Graph.Auth.route,
        startDestination = Screen.Signup.route
    ){
        composable(route = Screen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.Signup.route) {
            SignUpScreen(navController = navController)
        }
    }
}