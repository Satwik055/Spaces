package com.satwik.spaces.authentication.domain.model

data class User(
    val uid:String = "",
    val name:String = "",
    val email:String = "",
    val profilePicture:String = "",
    val bookings:List<String> = emptyList()
)
