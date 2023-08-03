package com.satwik.spaces.presentation.navigation


const val DETAIL_SCREEN_ARGUMENT_KEY ="id"

sealed class Screen(val route:String){
    object Home:Screen(route = "home_screen")
    object Detail:Screen(route = "detail_screen/{${DETAIL_SCREEN_ARGUMENT_KEY}}"){
        fun passId(id:Int): String {
            return "detail_screen/${id}"
        }
    }
    object Search:Screen(route = "search_screen")

}
