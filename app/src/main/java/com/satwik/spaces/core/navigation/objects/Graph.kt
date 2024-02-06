package com.satwik.spaces.core.navigation.objects

sealed class Graph(val route:String){
    object Auth: Graph(route=  "auth_graph")
    object Main: Graph(route = "main_graph")
}

