package com.satwik.spaces.authentication.domain.repository

import com.google.firebase.auth.FirebaseUser
import com.satwik.spaces.core.utils.Resource


interface AuthRepository {

    suspend fun signup(email:String, password:String): Resource<FirebaseUser>

    suspend fun login(email:String, password:String): Resource<FirebaseUser>

    fun getCurrentUser():FirebaseUser?

    fun logout()
}