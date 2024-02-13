package com.satwik.spaces.bookings.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.satwik.spaces.bookings.presentation.bookings_screen.BookingsScreen
import com.satwik.spaces.core.navigation.objects.Screen

fun NavGraphBuilder.bookingScreen(navController:NavController){
    composable(route= Screen.Booking.route){
        BookingsScreen(navController= navController)
    }
}