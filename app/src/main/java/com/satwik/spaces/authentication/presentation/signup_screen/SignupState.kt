package com.satwik.spaces.authentication.presentation.signup_screen

data class SignupState(
    val success:Boolean = false,
    val isLoading:Boolean = false,
    val error:String = ""
)
