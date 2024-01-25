package com.satwik.spaces.authentication.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.CollectionReference
import com.satwik.spaces.authentication.domain.model.User
import com.satwik.spaces.authentication.domain.repository.AuthRepository
import com.satwik.spaces.core.utils.qualifiers.UserCollection
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    @UserCollection private val usersCollection: CollectionReference,
    private val firebaseAuth:FirebaseAuth
) : AuthRepository {

    override suspend fun signup(email: String, password: String): FirebaseUser {
        //Creates firebase user
        val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()

        //Creates Spaces user, (in spaces 'User' firebase database)
        val uid = result.user!!.uid
        val userEmail = result.user!!.email
        val user = User(uid, userEmail!!)
        usersCollection.document(uid).set(user)

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