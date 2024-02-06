package com.satwik.spaces.core.navigation.graphs

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.satwik.spaces.core.navigation.objects.Graph
import com.satwik.spaces.core.navigation.objects.Screen
import com.satwik.spaces.core.navigation.objects.TabScreen
import com.satwik.spaces.location.presentation.address_screen.AddressScreen
import com.satwik.spaces.location.presentation.location_screen.LocationScreen
import com.satwik.spaces.payments.presentation.checkout_screen.CheckoutScreen
import com.satwik.spaces.payments.presentation.confirmation_screen.PaymentConfirmationScreen
import com.satwik.spaces.properties.presentation.detail_screen.DetailScreen
import com.satwik.spaces.properties.presentation.home_screen.HomeScreen
import com.satwik.spaces.properties.presentation.home_screen.tabs.screens.CoffeeshopTabScreen
import com.satwik.spaces.properties.presentation.home_screen.tabs.screens.LoungeTabScreen
import com.satwik.spaces.properties.presentation.home_screen.tabs.screens.MeetingroomTabScreen
import com.satwik.spaces.properties.presentation.home_screen.tabs.screens.WorkspaceTabScreen
import com.satwik.spaces.search.presentation.SearchScreen

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.mainGraph(navController: NavController){
    navigation(
        route = Graph.Main.route,
        startDestination = Screen.Home.route
    ) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController = navController)
        }

        composable(route = Screen.Detail.route) {
            DetailScreen(navController = navController)
        }

        composable(route = Screen.Search.route) {
            SearchScreen(navController = navController)
        }

        composable(route = Screen.Checkout.route) {
            CheckoutScreen(navController = navController)
        }

        composable(route = Screen.Location.route) {
            LocationScreen(navController = navController)
        }

        composable(route = Screen.PaymentConfirmationScreen.route) {
            PaymentConfirmationScreen(navController = navController)
        }

        composable(route = TabScreen.MeetingRoom.route) {
            MeetingroomTabScreen(navController = navController)
        }

        composable(route = TabScreen.Workspace.route) {
            WorkspaceTabScreen(navController = navController)
        }

        composable(route = TabScreen.Lounge.route) {
            LoungeTabScreen(navController = navController)
        }

        composable(route = TabScreen.Coffeeshop.route) {
            CoffeeshopTabScreen(navController = navController)
        }


        composable(route = Screen.PaymentConfirmationScreen.route) {
            PaymentConfirmationScreen(navController = navController)
        }

        composable(route = Screen.AddressScreen.route) {
            AddressScreen(navController = navController)
        }
    }
}