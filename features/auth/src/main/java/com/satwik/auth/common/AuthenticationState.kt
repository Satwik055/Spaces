package com.satwik.auth.common


data class AuthenticationState(
    val successfull:Boolean = false,
    val error: String = "",
    val isLoading:Boolean = false,
)
