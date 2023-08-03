package com.satwik.spaces.data.repository

import com.google.firebase.firestore.CollectionReference
import com.satwik.spaces.common.Resource
import com.satwik.spaces.domain.model.Property
import com.satwik.spaces.domain.repository.PropertiesRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class PropertiesRepositoryImpl @Inject constructor(
    private val propertiesRef:CollectionReference
):PropertiesRepository {

    override suspend fun getPropertiesFromFirestore(): List<Property> {
        TODO("Not yet implemented")
    }


}







/*
        val properties = arrayListOf<Property>()
        propertiesRef.addSnapshotListener { value, error ->
            if(value != null){
                val data =  value.toObjects(Property::class.java)
                properties.addAll(data)
            }
        }

*/