package com.satwik.booking.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.satwik.booking.presentation.BookingsScreen
import com.satwik.common.Screen


fun NavGraphBuilder.bookingScreen(navController:NavController){
    composable(route= Screen.Booking.route){
        BookingsScreen(navController= navController)
    }
}