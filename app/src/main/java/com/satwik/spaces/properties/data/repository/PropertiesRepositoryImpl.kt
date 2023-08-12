package com.satwik.spaces.properties.data.repository

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.toObject
import com.satwik.spaces.properties.domain.model.Property
import com.satwik.spaces.properties.domain.repository.PropertiesRepository
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class PropertiesRepositoryImpl @Inject constructor(
    private val collectionRef:CollectionReference
): PropertiesRepository {

    override suspend fun getAllProperties(): List<Property> {
        val querySnapshot = collectionRef.get().await()
        val properties = mutableListOf<Property>()
        for(document in querySnapshot.documents){
            val property = document.toObject<Property>()
            property?.let { properties.add(it) }
        }
        return properties
    }

    override suspend fun getPropertyById(id: String): Property?{
        val docSnapshot = collectionRef.document(id).get().await()
        return docSnapshot.toObject<Property>()
    }


}