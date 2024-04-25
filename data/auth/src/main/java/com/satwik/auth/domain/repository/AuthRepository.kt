package com.satwik.auth.domain.repository

import com.google.firebase.auth.FirebaseUser
import com.satwik.common.User


interface AuthRepository {

    suspend fun signup(email:String, password:String, username:String): FirebaseUser
    suspend fun login(email:String, password:String): FirebaseUser
    fun logout()
    suspend fun getCurrentUser(): User
    suspend fun oneTapSignIn(tokenId:String)
}