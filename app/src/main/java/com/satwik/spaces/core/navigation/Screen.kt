package com.satwik.spaces.core.navigation

import com.satwik.spaces.core.utils.Constants
import com.satwik.spaces.core.utils.Constants.CHECKOUT_SCREEN_ARGUMENT_KEYS


sealed class Screen(val route:String){
    object Home: Screen(route = "home_screen")
//    object Detail: Screen(
//        route = "detail_screen/" +
//                "{${Constants.DETAIL_SCREEN_ARGUMENT_KEY}}"
//    ){
//        fun passId(id: String): String {
//            return "detail_screen/$id"
//        }
//    }
    object Detail:Screen(route = "detail_screen")
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

    object MeetingRoomTabScreen:Screen(route = "meetingroom_tab_screen")

    object WorkspaceTabScreen:Screen(route = "workspace_tab_screen")

    object LoungeTabScreen:Screen(route = "lounge_tab_screen")

    object CoffeeshopTabScreen:Screen(route = "coffeeshop_tab_screen")
    object PaymentConfirmationScreen:Screen(route = "payment_confirmation_screen")

    object AddressScreen:Screen(route = "address_screen")


}
