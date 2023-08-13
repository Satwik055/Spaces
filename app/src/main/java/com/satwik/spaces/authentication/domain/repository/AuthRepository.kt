package com.satwik.spaces.authentication.domain.repository

import com.google.firebase.auth.FirebaseUser


interface AuthRepository {

    suspend fun signup(email:String, password:String): FirebaseUser?

    suspend fun login(email:String, password:String): FirebaseUser?

    fun getCurrentUser():FirebaseUser?

    fun logout()
}