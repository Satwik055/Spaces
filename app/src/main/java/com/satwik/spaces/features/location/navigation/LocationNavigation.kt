package com.satwik.spaces.features.location.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.satwik.spaces.core.navigation.objects.Screen
import com.satwik.spaces.features.location.presentation.location_screen.LocationScreen

fun NavGraphBuilder.locationScreen(navController:NavController){
    composable(route= Screen.Location.route){
        LocationScreen(navController= navController)
    }
}