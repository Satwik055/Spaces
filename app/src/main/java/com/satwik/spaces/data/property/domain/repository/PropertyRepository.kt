package com.satwik.spaces.data.property.domain.repository

import com.satwik.spaces.core.utils.PropertyType
import com.satwik.spaces.data.property.domain.model.Property

interface PropertyRepository {
    suspend fun getPropertyById(id:String): Property?
    suspend fun getPropertiesByType(type: PropertyType): List<Property>

}