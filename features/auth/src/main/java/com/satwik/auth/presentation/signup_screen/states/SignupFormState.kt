package com.satwik.auth.presentation.signup_screen.states

data class SignupFormState(
    val email:String = "",
    val emailError:String? = null,
    val password:String = "",
    val passwordError:String? = null,
    val name:String = "",
    val nameError:String? = null
)
