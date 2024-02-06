package com.satwik.spaces.core.navigation.setup

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.satwik.spaces.core.navigation.graphs.authGraph
import com.satwik.spaces.core.navigation.graphs.mainGraph
import com.satwik.spaces.core.navigation.objects.Graph
import com.satwik.spaces.core.navigation.objects.Screen
import com.satwik.spaces.core.navigation.objects.TabScreen
import com.satwik.spaces.payments.presentation.checkout_screen.CheckoutScreen
import com.satwik.spaces.location.presentation.address_screen.AddressScreen
import com.satwik.spaces.payments.presentation.confirmation_screen.PaymentConfirmationScreen
import com.satwik.spaces.properties.presentation.detail_screen.DetailScreen
import com.satwik.spaces.properties.presentation.home_screen.HomeScreen
import com.satwik.spaces.properties.presentation.home_screen.tabs.screens.CoffeeshopTabScreen
import com.satwik.spaces.properties.presentation.home_screen.tabs.screens.LoungeTabScreen
import com.satwik.spaces.properties.presentation.home_screen.tabs.screens.MeetingroomTabScreen
import com.satwik.spaces.properties.presentation.home_screen.tabs.screens.WorkspaceTabScreen
import com.satwik.spaces.location.presentation.location_screen.LocationScreen
import com.satwik.spaces.search.presentation.SearchScreen


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetupNavGraph(
    navController:NavHostController,
){

    var startDestination by remember { mutableStateOf("") }

    startDestination = Firebase.auth.currentUser?.let { Graph.Main.route } ?: Graph.Auth.route

    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        authGraph(navController = navController)

        mainGraph(navController = navController)
    }
}
