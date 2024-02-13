package com.satwik.spaces.authentication.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.satwik.spaces.authentication.presentation.login_screen.LoginScreen
import com.satwik.spaces.core.navigation.objects.Screen

fun NavGraphBuilder.loginScreen(navController: NavController){
    composable(
        route = Screen.Login.route,
    ) {
        LoginScreen(navController = navController)
    }
}