package com.satwik.spaces.authentication.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.satwik.spaces.core.navigation.objects.Graph
import com.satwik.spaces.core.navigation.objects.Screen

fun NavGraphBuilder.authGraph(navController:NavController){
    navigation(
        route = Graph.Auth.route,
        startDestination = Screen.Signup.route
    ){
        signupScreen(navController)

        loginScreen(navController)
    }
}