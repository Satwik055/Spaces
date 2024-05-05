package com.satwik.auth.domain.use_case.precondition

data class ValidationResult(
    val successfull:Boolean,
    val errorMessage:String? = null
)
