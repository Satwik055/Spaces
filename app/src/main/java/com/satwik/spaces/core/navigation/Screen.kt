package com.satwik.spaces.core.navigation

import com.satwik.spaces.properties.common.Constants


sealed class Screen(val route:String){
    object Home: Screen(route = "home_screen")
    object Detail: Screen(route = "detail_screen/{${Constants.DETAIL_SCREEN_ARGUMENT_KEY}}"){
        fun passId(id: String): String {
            return "detail_screen/${id}"
        }
    }
    object Search: Screen(route = "search_screen")
    object Signup: Screen(route = "signup_screen")
    object Login: Screen(route = "login_screen")
    object Confirmation: Screen(route = "confirmation_screen")

}
