package com.satwik.spaces.navigation.setup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.satwik.auth.navigation.authGraph
import com.satwik.booking.navigation.bookingScreen
import com.satwik.checkout.navigation.checkoutGraph
import com.satwik.detail.navigation.detailScreen
import com.satwik.explore.explore.navigation.exploreScreen
import com.satwik.location.navigation.locationScreen
import com.satwik.search.navigation.searchScreen
import com.satwik.spaces.main_screen.navigation.mainScreen
import com.satwik.spaces.navigation.model.Graph
import com.satwik.spaces.navigation.model.Screen


@Composable
fun SetupNavGraph(
    navController: NavHostController,
) {
    var startDestination by remember { mutableStateOf("") }

    startDestination = Firebase.auth.currentUser?.let { Screen.Main.route } ?: Graph.Auth.route

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        authGraph(navController)

        checkoutGraph(navController)

        mainScreen(navController)

        bookingScreen(navController)

        exploreScreen(navController)

        detailScreen(navController)

        searchScreen(navController)

        checkoutGraph(navController)

        locationScreen(navController)

    }
}
