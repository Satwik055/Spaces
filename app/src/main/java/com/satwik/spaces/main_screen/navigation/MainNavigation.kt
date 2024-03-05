package com.satwik.spaces.main_screen.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.satwik.spaces.main_screen.MainScreen
import com.satwik.spaces.navigation.model.Screen

fun NavGraphBuilder.mainScreen(navController:NavController){
    composable(route= Screen.Main.route){
        MainScreen(navController= navController)
    }
}