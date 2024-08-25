package com.satwik.property.domain.repository

import com.satwik.common.PropertyType
import com.satwik.spaces.model.Property

interface PropertyRepository {
    suspend fun getPropertyById(id:Int): Property
    suspend fun getPropertiesByType(type: PropertyType): List<Property>

}