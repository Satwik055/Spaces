package com.satwik.spaces.features.authentication.presentation

data class OneTapSignInState(
    val successfull:Boolean = false,
    val error:String? = null,
    val isLoading:Boolean = false
)
