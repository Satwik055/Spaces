package com.satwik.spaces.data.user.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.toObject
import com.satwik.spaces.core.utils.qualifiers.UserCollection
import com.satwik.spaces.data.auth.domain.model.User
import com.satwik.spaces.data.user.domain.repository.UserRepository
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    @UserCollection private val userCollection: CollectionReference,
    private val firebaseAuth: FirebaseAuth
):UserRepository {

    override suspend fun getCurrentSpacesUser(): User {
        return userCollection.document(firebaseAuth.uid!!).get().await().toObject<User>()!!
    }
}