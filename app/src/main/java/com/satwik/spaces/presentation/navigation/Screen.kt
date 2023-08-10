package com.satwik.spaces.presentation.navigation

import com.satwik.spaces.common.Constants


sealed class Screen(val route:String){
    object Home:Screen(route = "home_screen")
    object Detail:Screen(route = "detail_screen/{${Constants.DETAIL_SCREEN_ARGUMENT_KEY}}"){
        fun passId(id: String): String {
            return "detail_screen/${id}"
        }
    }
    object Search:Screen(route = "search_screen")

}
