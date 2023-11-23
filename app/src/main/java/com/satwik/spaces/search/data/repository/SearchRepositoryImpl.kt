package com.satwik.spaces.search.data.repository

import com.google.firebase.firestore.CollectionReference
import com.satwik.spaces.properties.domain.model.Property
import com.satwik.spaces.search.domain.repository.SearchRepository
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(private val collectionRef: CollectionReference
):SearchRepository {
    override suspend fun searchProperty(query: String): List<Property> {
        val querySnapshot = collectionRef.whereEqualTo("name", query).get().await()
        val properties = mutableListOf<Property>()
        for (document in querySnapshot) {
            val property = document.toObject(Property::class.java)
            properties.add(property)
        }
        return properties
    }

}