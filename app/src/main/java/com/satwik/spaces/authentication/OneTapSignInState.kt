package com.satwik.spaces.authentication

data class OneTapSignInState(
    val successfull:Boolean = false,
    val error:String? = null,
    val isLoading:Boolean = false
)
