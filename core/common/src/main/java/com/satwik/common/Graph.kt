package com.satwik.common

sealed class Graph(val route:String){
    object Auth: com.satwik.common.Graph(route=  "auth_graph")
    object Checkout: com.satwik.common.Graph(route = "checkout_graph"){
        fun passId(id: String): String {
            return "checkout_screen/$id"
        }
    }
}

