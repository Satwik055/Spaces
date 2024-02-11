package com.satwik.spaces.common.domain.model

data class User(
    val uid:String = "",
    val name:String = "",
    val email:String = "",
    val profilePicture:String = "",
    val bookings:List<String> = emptyList()
)
