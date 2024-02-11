package com.satwik.spaces.core.navigation.objects


sealed class Screen(val route:String){
    object Main:Screen(route="main_screen")
    object Explore: Screen(route = "explore_screen")
    object Detail: Screen(route = "detail_screen/" + "{${"propertyId"}}"){
        fun passId(id: String): String {
            return "detail_screen/$id"
        }
    }
    object Search: Screen(route = "search_screen")
    object Signup: Screen(route = "signup_screen")
    object Login: Screen(route = "login_screen")
    object Checkout: Screen(route = "checkout_screen/" + "{${"propertyId"}}"){
        fun passId(id: String): String {
            return "checkout_screen/$id"
        }
    }
    object Location: Screen(route = "location_screen")
    object Booking:Screen(route="booking_screen")
    object PaymentConfirmationScreen: Screen(route = "payment_confirmation_screen")
    object AddressScreen: Screen(route = "address_screen")
}
