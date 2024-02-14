package com.satwik.spaces.features.authentication.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.satwik.spaces.features.authentication.presentation.signup_screen.SignUpScreen
import com.satwik.spaces.core.navigation.objects.Screen

fun NavGraphBuilder.signupScreen(navController: NavController){
    composable(
        route = Screen.Signup.route,
    ) {
        SignUpScreen(navController = navController)
    }
}