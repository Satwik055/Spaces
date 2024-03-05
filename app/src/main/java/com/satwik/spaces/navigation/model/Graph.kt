package com.satwik.spaces.navigation.model

sealed class Graph(val route:String){
    object Auth: Graph(route=  "auth_graph")
    object Checkout: Graph(route = "checkout_graph"){
        fun passId(id: String): String {
            return "checkout_screen/$id"
        }
    }
}

