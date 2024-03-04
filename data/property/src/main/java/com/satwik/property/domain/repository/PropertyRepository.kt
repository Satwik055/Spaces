package com.satwik.property.domain.repository

import com.satwik.common.PropertyType
import com.satwik.spaces.data.property.domain.model.Property

interface PropertyRepository {
    suspend fun getPropertyById(id:String): Property?
    suspend fun getPropertiesByType(type: PropertyType): List<Property>

}