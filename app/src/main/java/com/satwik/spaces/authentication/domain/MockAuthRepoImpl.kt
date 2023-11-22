package com.satwik.spaces.authentication.domain

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.satwik.spaces.authentication.domain.repository.AuthRepository
import com.satwik.spaces.core.utils.Resource
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class MockAuthRepoImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
):MockAuthRepo {

    override suspend fun login(email: String, password: String): FirebaseUser {
        val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
        return result.user!!
    }
}