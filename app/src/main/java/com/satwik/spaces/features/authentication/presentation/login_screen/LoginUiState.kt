package com.satwik.spaces.features.authentication.presentation.login_screen

import com.google.firebase.auth.FirebaseUser

data class LoginUiState(
    val user: FirebaseUser? = null,
    val error: String? = null,
    val isLoading:Boolean = false
)
