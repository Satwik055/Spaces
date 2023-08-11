package com.satwik.spaces.data.repository

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.satwik.spaces.common.Constants
import com.satwik.spaces.common.DummyApi
import com.satwik.spaces.common.Resource
import com.satwik.spaces.domain.model.Property
import com.satwik.spaces.domain.repository.PropertiesRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class PropertiesRepositoryImpl @Inject constructor(
    private val collectionRef:CollectionReference
):PropertiesRepository {

    override suspend fun getAllProperties(): List<Property> {
        val querySnapshot = collectionRef.get().await()
        val properties = mutableListOf<Property>()
        for(document in querySnapshot.documents){
            val property = document.toObject<Property>()
            property?.let { properties.add(it) }
        }
        return properties
    }

    override suspend fun getPropertyById(id: String):Property?{
        val docSnapshot = collectionRef.document(id).get().await()
        return docSnapshot.toObject<Property>()
    }


}