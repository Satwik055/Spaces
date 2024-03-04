package com.satwik.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.satwik.auth.presentation.login_screen.LoginScreen
import com.satwik.auth.presentation.signup_screen.SignUpScreen
import com.satwik.common.Graph
import com.satwik.common.Screen

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