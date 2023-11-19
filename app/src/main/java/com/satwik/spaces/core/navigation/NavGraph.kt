package com.satwik.spaces.core.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.satwik.spaces.authentication.presentation.login_screen.LoginScreen
import com.satwik.spaces.authentication.presentation.signup_screen.SignUpScreen
import com.satwik.spaces.payments.presentation.checkout_screen.CheckoutScreen
import com.satwik.spaces.properties.common.Constants
import com.satwik.spaces.properties.common.Constants.CHECKOUT_SCREEN_ARGUMENT_KEYS
import com.satwik.spaces.properties.presentation.detail_screen.DetailScreen
import com.satwik.spaces.properties.presentation.home_screen.HomeScreen
import com.satwik.spaces.properties.presentation.home_screen.tabs.coffeeshop_tab.CoffeeshopTabScreen
import com.satwik.spaces.properties.presentation.home_screen.tabs.lounge_tab.LoungeTabScreen
import com.satwik.spaces.properties.presentation.home_screen.tabs.meetingroom_tab.MeetingroomTabScreen
import com.satwik.spaces.properties.presentation.home_screen.tabs.workspace_tab.WorkspaceTabScreen
import com.satwik.spaces.properties.presentation.location_screen.LocationScreen
import com.satwik.spaces.properties.presentation.search_screen.SearchScreen


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetupNavGraph(navController:NavHostController){

    var startDestination by remember { mutableStateOf("") }

    if (Firebase.auth.currentUser != null){
        startDestination = Screen.Home.route
    }
    else{
        startDestination = Screen.Signup.route
    }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable(
            route = Screen.Home.route){
            HomeScreen(navController = navController)
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument(Constants.DETAIL_SCREEN_ARGUMENT_KEY){ type = NavType.StringType }
            )
        ) {
            DetailScreen(navController = navController)
        }

        composable(route = Screen.Search.route){
            SearchScreen(navController = navController)
        }

        composable(route = Screen.Signup.route){
            SignUpScreen(navController = navController)
        }

        composable(route = Screen.Login.route){
            LoginScreen(navController = navController)
        }

        composable(
            route = Screen.Checkout.route,
            arguments = listOf(
                navArgument(CHECKOUT_SCREEN_ARGUMENT_KEYS[0]){ type = NavType.StringType },
                navArgument(CHECKOUT_SCREEN_ARGUMENT_KEYS[1]){ type = NavType.StringType },
                navArgument(CHECKOUT_SCREEN_ARGUMENT_KEYS[2]){ type = NavType.StringType },
                navArgument(CHECKOUT_SCREEN_ARGUMENT_KEYS[3]){ type = NavType.StringType }
            )
        ) {
            CheckoutScreen(navController=navController)
        }

        composable(route = Screen.Location.route){
            LocationScreen(navController = navController)
        }

        composable(route = Screen.MeetingRoomTabScreen.route){
            MeetingroomTabScreen(navController = navController)
        }

        composable(route = Screen.WorkspaceTabScreen.route){
            WorkspaceTabScreen(navController = navController)
        }

        composable(route = Screen.LoungeTabScreen.route){
            LoungeTabScreen(navController = navController)
        }

        composable(route = Screen.CoffeeshopTabScreen.route){
            CoffeeshopTabScreen(navController = navController)
        }

    }
}
