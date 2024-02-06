package com.satwik.spaces.payments.domain.model


data class Booking(
    val uid:String = "",
    val people:String = "",
    val checkInDate: String = "",
    val checkOutDate: String = "",
    val propertyId:String = "",
)
