package com.satwik.spaces.authentication.domain

import com.google.firebase.auth.FirebaseUser

interface MockAuthRepo {
    suspend fun login(email:String, password:String):FirebaseUser

}