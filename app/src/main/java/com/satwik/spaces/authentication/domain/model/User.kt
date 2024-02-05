package com.satwik.spaces.authentication.domain.model

typealias bookingId = String
data class User(
    val uid:String,
    val name:String,
    val email:String,
    val bookings:List<String> = emptyList()
)
