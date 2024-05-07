package com.satwik.auth.presentation.signup_screen.states


data class AuthenticationState(
    val successfull:Boolean = false,
    val error: String = "",
    val isLoading:Boolean = false,
)
