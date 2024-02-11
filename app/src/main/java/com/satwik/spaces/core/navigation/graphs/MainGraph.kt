package com.satwik.spaces.core.navigation.graphs


import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.satwik.spaces.bookings.presentation.bookings_screen.BookingsScreen
import com.satwik.spaces.core.navigation.objects.Graph
import com.satwik.spaces.core.navigation.objects.Screen
import com.satwik.spaces.core.navigation.objects.TabScreen
import com.satwik.spaces.core.ui.main_screen.MainScreen
import com.satwik.spaces.core.utils.Constants.CHECKOUT_SCREEN_ARGUMENT_KEY
import com.satwik.spaces.core.utils.Constants.DETAIL_SCREEN_ARGUMENT_KEY
import com.satwik.spaces.details.presentation.detail_screen.DetailScreen
import com.satwik.spaces.explore.presentation.explore_screen.ExploreScreen
import com.satwik.spaces.explore.presentation.explore_screen.tabs.screens.CoffeeshopTabScreen
import com.satwik.spaces.explore.presentation.explore_screen.tabs.screens.LoungeTabScreen
import com.satwik.spaces.explore.presentation.explore_screen.tabs.screens.MeetingroomTabScreen
import com.satwik.spaces.explore.presentation.explore_screen.tabs.screens.WorkspaceTabScreen
import com.satwik.spaces.location.presentation.address_screen.AddressScreen
import com.satwik.spaces.location.presentation.location_screen.LocationScreen
import com.satwik.spaces.payments.presentation.checkout_screen.CheckoutScreen
import com.satwik.spaces.payments.presentation.confirmation_screen.PaymentConfirmationScreen
import com.satwik.spaces.search.presentation.SearchScreen

fun NavGraphBuilder.mainGraph(navController: NavController){
    navigation(
        route = Graph.Main.route,
        startDestination = Screen.Main.route
    ) {
        composable(route= Screen.Main.route){
            MainScreen(navController = navController)
        }

        composable(route=Screen.Booking.route){
            BookingsScreen(navController= navController)
        }

        composable(route = Screen.Explore.route) {
            ExploreScreen(navController = navController)
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument(DETAIL_SCREEN_ARGUMENT_KEY){
                type = NavType.StringType
            })
        ) {
            DetailScreen(navController = navController)
        }

        composable(route = Screen.Search.route) {
            SearchScreen(navController = navController)
        }

        composable(
            route = Screen.Checkout.route,
            arguments = listOf(navArgument(CHECKOUT_SCREEN_ARGUMENT_KEY){
                type = NavType.StringType
            })
        ) {
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