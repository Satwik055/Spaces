package com.satwik.auth.domain.use_case.login_precondition

import android.util.Patterns
import com.satwik.auth.domain.use_case.signup_precondition.ValidationResult
import javax.inject.Inject

class ValidateEmailUsecase @Inject constructor() {

    fun execute(email:String): ValidationResult {
        if(email.isBlank()){
            return ValidationResult(false, errorMessage = "Please enter an email")
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return ValidationResult(false, errorMessage = "Please enter valid email")
        }
        return ValidationResult(true)
    }
}