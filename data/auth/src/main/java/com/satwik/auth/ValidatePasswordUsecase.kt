package com.satwik.auth

import javax.inject.Inject

class ValidatePasswordUsecase @Inject constructor() {

    fun execute(password:String):ValidationResult{
        if(password.isBlank()){
            return ValidationResult(false, errorMessage = "Please enter a password")
        }
        return ValidationResult(true)
    }
}