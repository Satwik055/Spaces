package com.satwik.auth.domain.use_case.precondition

import javax.inject.Inject

class ValidatePasswordUsecase @Inject constructor() {

    fun execute(password:String): ValidationResult {
        if(password.isBlank()){
            return ValidationResult(false, errorMessage = "Please enter a password")
        }
        if(password.length<6){
            return ValidationResult(false, errorMessage = "Password must be at least 6 characters long")
        }
        if(password.length>30){
            return ValidationResult(false, errorMessage = "Password must be less than 30 characters")
        }
        return ValidationResult(true)
    }
}