package com.satwik.spaces.authentication.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.satwik.spaces.authentication.domain.repository.AuthRepository
import com.satwik.spaces.core.utils.Resource
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth:FirebaseAuth
) : AuthRepository {

    override suspend fun signup(email: String, password: String): Resource<FirebaseUser> {
        return try{
            val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            Resource.Success(result.user!!)
        }
        catch (e:Exception){
            Resource.Error(e.localizedMessage?:"An unexpected error occurred")
        }

    }

    override suspend fun login(email: String, password: String): Resource<FirebaseUser> {
        return try{
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Resource.Success(result.user!!)
        }
        catch (e:Exception){
            Resource.Error(e.localizedMessage?:"An unexpected error occurred")
        }
    }

    override fun getCurrentUser(): FirebaseUser? {
        return firebaseAuth.currentUser
    }

    override fun logout() {
        firebaseAuth.signOut()
    }
}