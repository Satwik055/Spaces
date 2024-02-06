package com.satwik.spaces.core.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.satwik.spaces.authentication.presentation.login_screen.LoginScreen
import com.satwik.spaces.authentication.presentation.signup_screen.SignUpScreen
import com.satwik.spaces.core.navigation.objects.Graph
import com.satwik.spaces.core.navigation.objects.Screen

fun NavGraphBuilder.authGraph(navController:NavController){
    navigation(
        route = Graph.Auth.route,
        startDestination = Screen.Signup.route
    ){
        composable(route = Screen.Signup.route){
            SignUpScreen(navController = navController)
        }
        composable(route = Screen.Login.route){
            LoginScreen(navController = navController)
        }
    }
}