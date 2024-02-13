package com.satwik.spaces.payments.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.satwik.spaces.core.navigation.objects.Screen
import com.satwik.spaces.core.utils.Constants
import com.satwik.spaces.payments.presentation.checkout_screen.CheckoutScreen

fun NavGraphBuilder.checkoutScreen(navController:NavController){
    composable(
        route = Screen.Checkout.route,
        arguments = listOf(navArgument(Constants.CHECKOUT_SCREEN_ARGUMENT_KEY){
            type = NavType.StringType
        })
    ) {
        CheckoutScreen(navController = navController)
    }
}