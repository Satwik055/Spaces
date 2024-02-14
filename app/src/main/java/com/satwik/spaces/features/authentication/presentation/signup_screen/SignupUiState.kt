package com.satwik.spaces.features.authentication.presentation.signup_screen

import com.google.firebase.auth.FirebaseUser

data class SignupUiState(
    val user: FirebaseUser? = null,
    val error: String? = null,
    val isLoading:Boolean = false,
    val signInByButton:Boolean = false,
    val buttonSignInSuccessfull:Boolean = false
)
