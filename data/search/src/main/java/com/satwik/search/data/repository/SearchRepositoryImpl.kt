package com.satwik.search.data.repository

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.toObject
import com.satwik.common.Property
import com.satwik.exceptions.NoPropertiesFound
import com.satwik.qualifiers.PropertyCollection
import com.satwik.search.domain.repository.SearchRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    @PropertyCollection private val propertyCollectionRef: CollectionReference
): SearchRepository {

    override suspend fun searchProperty(query: String): List<Property> {
        if (query.isBlank()) {
            return emptyList()
        }

        val querySnapshot = propertyCollectionRef.get().await()
        val allProperties = querySnapshot.documents.mapNotNull { it.toObject<Property>() }

        val result = allProperties.filter { it.name.contains(query) }

        if (result.isEmpty()) {
            throw NoPropertiesFound()
        }

        delay(1000)
        return result
    }
}