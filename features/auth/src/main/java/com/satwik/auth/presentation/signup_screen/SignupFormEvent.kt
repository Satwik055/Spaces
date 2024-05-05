package com.satwik.auth.presentation.signup_screen

sealed class SignupFormEvent {
    data class EmailChanged(val email:String):SignupFormEvent()
    data class PasswordChanged(val password:String):SignupFormEvent()
    data class NameChanged(val name:String):SignupFormEvent()

    object Submit:SignupFormEvent()
}