package com.satwik.spaces.common.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.toObject
import com.satwik.spaces.common.domain.model.Property
import com.satwik.spaces.common.domain.model.User
import com.satwik.spaces.common.domain.repository.CommonRepository
import com.satwik.spaces.core.utils.qualifiers.PropertyCollection
import com.satwik.spaces.core.utils.qualifiers.UserCollection
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class CommonRepositoryImpl @Inject constructor(
    @UserCollection private val userCollection: CollectionReference,
    @PropertyCollection private val propertyCollectionRef:CollectionReference,
    private val firebaseAuth: FirebaseAuth
): CommonRepository {

    override suspend fun getCurrentSpacesUser(): User {
        return userCollection.document(firebaseAuth.uid!!).get().await().toObject<User>()!!
    }

    override suspend fun getPropertyById(id: String): Property? {
        val docSnapshot = propertyCollectionRef.document(id).get().await()
        return docSnapshot.toObject<Property>()
    }
}