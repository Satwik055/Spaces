package com.satwik.spaces.authentication.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.CollectionReference
import com.satwik.spaces.common.domain.model.User
import com.satwik.spaces.authentication.domain.repository.AuthRepository
import com.satwik.spaces.core.utils.qualifiers.UserCollection
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    @UserCollection private val usersCollection: CollectionReference,
    private val firebaseAuth:FirebaseAuth
) : AuthRepository {

    override suspend fun signup(email: String, password: String, username:String): FirebaseUser {
        //Creates new firebase user
        val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
        val firebaseUser = result.user

        //Creates new Spaces user, (in firestore 'User' collection)
        firebaseUser?.let {
            val spacesUserUid = it.uid
            val spacesUserEmail = it.email
            val user = User(spacesUserUid,username, spacesUserEmail!!)
            usersCollection.document(spacesUserUid).set(user)
        }
        return firebaseUser!!
    }


    override suspend fun login(email: String, password: String): FirebaseUser {
        val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
        val firebaseUser = result.user
        return firebaseUser!!
    }

    override suspend fun oneTapSignIn(tokenId: String) {
        val firebaseCred = GoogleAuthProvider.getCredential(tokenId, null)
        firebaseAuth.signInWithCredential(firebaseCred)
    }
}