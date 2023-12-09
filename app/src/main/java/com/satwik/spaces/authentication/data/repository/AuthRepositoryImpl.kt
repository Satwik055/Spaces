package com.satwik.spaces.authentication.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.satwik.spaces.authentication.domain.repository.AuthRepository
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth:FirebaseAuth
) : AuthRepository {

    override suspend fun signup(email: String, password: String): FirebaseUser {
        val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
        return result.user!!
    }

    override suspend fun login(email: String, password: String): FirebaseUser {
        val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
        return result.user!!
    }

    override suspend fun oneTapSignIn(tokenId: String) {
        val firebaseCred = GoogleAuthProvider.getCredential(tokenId, null)
        firebaseAuth.signInWithCredential(firebaseCred)
    }
}