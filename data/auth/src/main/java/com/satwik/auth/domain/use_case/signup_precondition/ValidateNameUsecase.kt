package com.satwik.auth.domain.use_case.signup_precondition

import javax.inject.Inject

class ValidateNameUsecase @Inject constructor() {
    fun execute(name:String): ValidationResult {
        if(name.isBlank()){
            return ValidationResult(false, errorMessage = "Please enter your name")
        }
        if(name.length>30){
            return ValidationResult(false, errorMessage = "name must be less than 30 characters")
        }
        return ValidationResult(true)
    }
}