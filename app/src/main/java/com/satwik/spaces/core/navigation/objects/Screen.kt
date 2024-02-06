package com.satwik.spaces.core.navigation.objects


sealed class Screen(val route:String){
    object Home: Screen(route = "home_screen")
    object Detail: Screen(route = "detail_screen")
    object Search: Screen(route = "search_screen")
    object Signup: Screen(route = "signup_screen")
    object Login: Screen(route = "login_screen")
    object Checkout: Screen(route = "checkout_screen")
    object Location: Screen(route = "location_screen")
    object PaymentConfirmationScreen: Screen(route = "payment_confirmation_screen")
    object AddressScreen: Screen(route = "address_screen")
}
