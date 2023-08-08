package com.satwik.spaces.data.repository

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
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

    override suspend fun getAllProperties() = DummyApi.getAllProperties()
    override suspend fun getPropertyById(id: Int) = DummyApi.getPropertyById(id)!!

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


/*
        val snapshot = collectionRef.get().await()
        val list = mutableListOf<Property>()

        for(document in snapshot.documents){
            val myObj = document.toObject(Property::class.java)
            myObj?.let{list.add(it)}
        }
        return list

*/