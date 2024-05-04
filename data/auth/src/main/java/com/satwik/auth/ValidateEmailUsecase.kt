package com.satwik.auth

import javax.inject.Inject

class ValidateEmailUsecase @Inject constructor() {

    fun execute(email:String):ValidationResult{
        if(email.isBlank()){
            return ValidationResult(false, errorMessage = "Please enter an email")
        }
        return ValidationResult(true)
    }
}