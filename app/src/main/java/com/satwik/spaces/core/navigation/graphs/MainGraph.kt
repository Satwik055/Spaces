package com.satwik.spaces.core.navigation.graphs


import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.satwik.spaces.core.navigation.objects.Graph
import com.satwik.spaces.core.navigation.objects.Screen
import com.satwik.spaces.core.navigation.objects.TabScreen
import com.satwik.spaces.core.ui.main_screen.navigation.mainScreen
import com.satwik.spaces.features.bookings.navigation.bookingScreen
import com.satwik.spaces.features.details.navigation.detailScreen
import com.satwik.spaces.features.explore.navigation.exploreScreen
import com.satwik.spaces.features.explore.presentation.explore_screen.tabs.screens.CoffeeshopTabScreen
import com.satwik.spaces.features.explore.presentation.explore_screen.tabs.screens.LoungeTabScreen
import com.satwik.spaces.features.explore.presentation.explore_screen.tabs.screens.MeetingroomTabScreen
import com.satwik.spaces.features.explore.presentation.explore_screen.tabs.screens.WorkspaceTabScreen
import com.satwik.spaces.features.location.navigation.locationScreen
import com.satwik.spaces.features.location.presentation.address_screen.AddressScreen
import com.satwik.spaces.features.payments.navigation.checkoutScreen
import com.satwik.spaces.features.payments.presentation.confirmation_screen.PaymentConfirmationScreen
import com.satwik.spaces.features.search.navigation.searchScreen

fun NavGraphBuilder.mainGraph(navController: NavController){
    navigation(
        route = Graph.Main.route,
        startDestination = Screen.Main.route
    ) {
        mainScreen(navController)

        bookingScreen(navController)

        exploreScreen(navController)

        detailScreen(navController)

        searchScreen(navController)

        checkoutScreen(navController)

        locationScreen(navController)

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