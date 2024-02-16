package com.satwik.spaces.data.property.data

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.toObject
import com.satwik.spaces.core.utils.PropertyType
import com.satwik.spaces.core.utils.exceptions.NoPropertiesFound
import com.satwik.spaces.core.utils.qualifiers.PropertyCollection
import com.satwik.spaces.data.property.domain.model.Property
import com.satwik.spaces.data.property.domain.repository.PropertyRepository
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class PropertyRepositoryImpl @Inject constructor(
    @PropertyCollection private val propertyCollectionRef:CollectionReference,
): PropertyRepository {

    override suspend fun getPropertyById(id: String): Property? {
        val docSnapshot = propertyCollectionRef.document(id).get().await()
        return docSnapshot.toObject<Property>()
    }

    override suspend fun getPropertiesByType(type: PropertyType): List<Property> {
        val querySnapshot = propertyCollectionRef.whereEqualTo("type",type.name.lowercase()).get().await()
        val properties = mutableListOf<Property>()
        for(document in querySnapshot.documents){
            val property = document.toObject<Property>()
            property?.let { properties.add(it) }
        }
        if(properties.isEmpty()){
            throw NoPropertiesFound()
        }
        return properties
    }
}