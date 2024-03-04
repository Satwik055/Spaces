package com.satwik.auth.presentation

data class OneTapSignInState(
    val successfull:Boolean = false,
    val error:String? = null,
    val isLoading:Boolean = false
)
