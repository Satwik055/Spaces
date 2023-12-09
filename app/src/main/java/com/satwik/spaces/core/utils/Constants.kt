package com.satwik.spaces.core.utils

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

    const val CLIENT_ID = "507948844102-d5occ2m65gm2kg3ifbmg3ocosi2v0qsc.apps.googleusercontent.com"
    const val PUBLISHABLE_KEY ="pk_test_51IlFYySIaKPCt7ZQaomoRMMVEjhy3CHnGLk6WvTUOzltBfWBLZOM8Gxi8qVfVPNEKl9B5QAuyVluCL6B2NRCfxCo00BE8Faezw"
    const val TEST_KEY = "sk_test_51IlFYySIaKPCt7ZQOAVwXGDaM1p5457AeYSANyjYxWdP4C4RX60i8JT5YN36dg798rgJx3DIXKdhm7jS67gOjKgj00zQ7OSlk4"



}