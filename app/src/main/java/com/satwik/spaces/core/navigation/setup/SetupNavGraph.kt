package com.satwik.spaces.core.navigation.setup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.satwik.spaces.core.navigation.graphs.mainGraph
import com.satwik.spaces.core.navigation.objects.Graph
import com.satwik.spaces.features.authentication.navigation.authGraph


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
