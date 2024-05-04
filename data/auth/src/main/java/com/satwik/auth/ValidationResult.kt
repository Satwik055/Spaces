package com.satwik.auth

data class ValidationResult(
    val successfull:Boolean,
    val errorMessage:String? = null
)
