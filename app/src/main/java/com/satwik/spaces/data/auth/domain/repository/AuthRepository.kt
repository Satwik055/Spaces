package com.satwik.spaces.data.auth.domain.repository

import com.google.firebase.auth.FirebaseUser
import com.satwik.spaces.data.auth.domain.model.User


interface AuthRepository {

    suspend fun signup(email:String, password:String, username:String): FirebaseUser
    suspend fun login(email:String, password:String): FirebaseUser
    suspend fun getCurrentUser(): User
    suspend fun oneTapSignIn(tokenId:String)
}