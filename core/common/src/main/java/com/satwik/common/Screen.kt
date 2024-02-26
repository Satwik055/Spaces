package com.satwik.common


sealed class Screen(val route:String){
    object Main: com.satwik.common.Screen(route="main_screen")
    object Explore: com.satwik.common.Screen(route = "explore_screen")
    object Detail: com.satwik.common.Screen(route = "detail_screen/" + "{${"propertyId"}}"){
        fun passId(id: String): String {
            return "detail_screen/$id"
        }
    }
    object Search: com.satwik.common.Screen(route = "search_screen")
    object Signup: com.satwik.common.Screen(route = "signup_screen")
    object Login: com.satwik.common.Screen(route = "login_screen")
    object Checkout: com.satwik.common.Screen(route = "checkout_screen/" + "{${"propertyId"}}")
    object Location: com.satwik.common.Screen(route = "location_screen")
    object Booking: com.satwik.common.Screen(route="booking_screen")
    object PaymentConfirmationScreen: com.satwik.common.Screen(route = "payment_confirmation_screen")
    object AddressScreen: com.satwik.common.Screen(route = "address_screen")
}
