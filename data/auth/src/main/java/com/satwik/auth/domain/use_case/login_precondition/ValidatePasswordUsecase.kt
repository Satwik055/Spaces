package com.satwik.auth.domain.use_case.login_precondition

import com.satwik.auth.domain.use_case.signup_precondition.ValidationResult
import javax.inject.Inject

class ValidatePasswordUsecase @Inject constructor() {

    fun execute(password:String): ValidationResult {
        if(password.isBlank()){
            return ValidationResult(false, errorMessage = "Please enter a password")
        }
        return ValidationResult(true)
    }
}