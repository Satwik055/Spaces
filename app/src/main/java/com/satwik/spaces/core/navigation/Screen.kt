package com.satwik.spaces.core.navigation

import com.satwik.spaces.properties.common.Constants
import com.satwik.spaces.properties.common.Constants.CHECKOUT_SCREEN_ARGUMENT_KEY1
import com.satwik.spaces.properties.common.Constants.CHECKOUT_SCREEN_ARGUMENT_KEY2
import com.satwik.spaces.properties.common.Constants.CHECKOUT_SCREEN_ARGUMENT_KEY3
import com.satwik.spaces.properties.common.Constants.CHECKOUT_SCREEN_ARGUMENT_KEY4
import com.satwik.spaces.properties.common.Constants.CHECKOUT_SCREEN_ARGUMENT_KEYS


sealed class Screen(val route:String){
    object Home: Screen(route = "home_screen")
    object Detail: Screen(
        route = "detail_screen/" +
                "{${Constants.DETAIL_SCREEN_ARGUMENT_KEY}}"
    ){
        fun passId(id: String): String {
            return "detail_screen/$id"
        }
    }
    object Search: Screen(route = "search_screen")
    object Signup: Screen(route = "signup_screen")
    object Login: Screen(route = "login_screen")
    object Checkout: Screen(
        route = "checkout_screen/" +
                "{${CHECKOUT_SCREEN_ARGUMENT_KEYS[0]}}/" +
                "{${CHECKOUT_SCREEN_ARGUMENT_KEYS[1]}}/" +
                "{${CHECKOUT_SCREEN_ARGUMENT_KEYS[2]}}/" +
                "{${CHECKOUT_SCREEN_ARGUMENT_KEYS[3]}}"
    ){
        fun passBookingInfo(
            id: String,
            startDate:String,
            endDate:String,
            people:String
        ): String {
            return "checkout_screen/$id/$startDate/$endDate/$people"
        }
    }
    object Location:Screen(route = "location_screen")
}
