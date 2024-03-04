package com.satwik.location.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.satwik.common.Screen
import com.satwik.location.presentation.location_screen.LocationScreen

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.locationScreen(navController:NavController){
    composable(route= Screen.Location.route ){
        LocationScreen(navController= navController)
    }
}