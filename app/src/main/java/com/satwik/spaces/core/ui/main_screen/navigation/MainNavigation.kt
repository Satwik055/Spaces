package com.satwik.spaces.core.ui.main_screen.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.satwik.spaces.core.navigation.objects.Screen
import com.satwik.spaces.core.ui.main_screen.MainScreen

fun NavGraphBuilder.mainScreen(navController:NavController){
    composable(route= Screen.Main.route){
        MainScreen(navController= navController)
    }
}