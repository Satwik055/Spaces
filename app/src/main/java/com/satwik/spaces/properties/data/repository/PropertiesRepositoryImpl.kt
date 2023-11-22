package com.satwik.spaces.properties.data.repository

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.toObject
import com.satwik.spaces.core.exceptions.InvalidPropertyType
import com.satwik.spaces.core.utils.PropertyType
import com.satwik.spaces.properties.domain.model.Property
import com.satwik.spaces.properties.domain.repository.PropertiesRepository
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class PropertiesRepositoryImpl @Inject constructor(
    private val collectionRef:CollectionReference
): PropertiesRepository {

    override suspend fun getPropertiesByType(type: PropertyType): List<Property> {
//        val availablePropertyTypes = listOf("meetingroom", "workspace", "lounge", "coffeeshop")
//        if(type !in availablePropertyTypes){
//            throw InvalidPropertyType()
//        }
//        else{
//
//        }
        val querySnapshot = collectionRef.whereEqualTo("type",type.name.lowercase()).get().await()
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

    override suspend fun searchProperty(name: String): List<Property>? {
        val querySnapshot = collectionRef.whereEqualTo("name", name).get().await()
        val properties = mutableListOf<Property>()
        for (document in querySnapshot) {
            val property = document.toObject(Property::class.java)
            properties.add(property)
        }
        return properties

    }


}