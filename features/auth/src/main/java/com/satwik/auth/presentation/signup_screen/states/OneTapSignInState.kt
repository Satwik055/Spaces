package com.satwik.auth.presentation.signup_screen.states

data class OneTapSignInState(
    val successfull:Boolean = false,
    val error:String? = null,
    val isLoading:Boolean = false
)
