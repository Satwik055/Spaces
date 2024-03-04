package com.satwik.checkout.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.satwik.checkout.presentation.checkout_screen.CheckoutScreen
import com.satwik.checkout.presentation.confirmation_screen.PaymentConfirmationScreen
import com.satwik.common.Constants
import com.satwik.common.Graph
import com.satwik.common.Screen

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