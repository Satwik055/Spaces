package com.satwik.spaces.features.checkout.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.satwik.spaces.core.navigation.objects.Graph
import com.satwik.spaces.core.navigation.objects.Screen
import com.satwik.spaces.core.utils.Constants
import com.satwik.spaces.features.checkout.presentation.checkout_screen.CheckoutScreen
import com.satwik.spaces.features.checkout.presentation.confirmation_screen.PaymentConfirmationScreen

fun NavGraphBuilder.checkoutGraph(navController:NavController){
    navigation(
        route = Graph.Checkout.route,
        startDestination = Screen.Checkout.route
    ){
        composable(
            route = Screen.Checkout.route,
            arguments = listOf(navArgument(Constants.CHECKOUT_SCREEN_ARGUMENT_KEY){
                type = NavType.StringType
            })
        ) {
            CheckoutScreen(navController = navController)
        }

        composable(route = Screen.PaymentConfirmationScreen.route) {
            PaymentConfirmationScreen(navController = navController)
        }
    }

}