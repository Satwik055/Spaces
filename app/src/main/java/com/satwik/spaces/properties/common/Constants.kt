package com.satwik.spaces.properties.common

import okhttp3.internal.immutableListOf

object Constants {

    //Firestore
    const val PROPERTIES = "Property"

    //Navigation arg key
    const val DETAIL_SCREEN_ARGUMENT_KEY = "propertyId"
    const val CHECKOUT_SCREEN_ARGUMENT_KEY1 = "propertyId"
    const val CHECKOUT_SCREEN_ARGUMENT_KEY2 = "startDate"
    const val CHECKOUT_SCREEN_ARGUMENT_KEY3 = "endDate"
    const val CHECKOUT_SCREEN_ARGUMENT_KEY4 = "people"
    val CHECKOUT_SCREEN_ARGUMENT_KEYS = immutableListOf( "propertyId", "startDate", "endDate", "people")





}