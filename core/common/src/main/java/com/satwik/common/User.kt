package com.satwik.common

data class User(
    val uid:String = "",
    val name:String = "",
    val email:String = "",
    val profilePicture:String = "https://i.pinimg.com/originals/ac/11/aa/ac11aa2add3b0193c8769e0a17d13535.jpg",
    val bookings:List<String> = emptyList()
)
