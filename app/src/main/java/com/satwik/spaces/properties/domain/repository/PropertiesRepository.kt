package com.satwik.spaces.properties.domain.repository

import com.satwik.spaces.core.utils.PropertyType
import com.satwik.spaces.properties.domain.model.Property


interface PropertiesRepository{
    suspend fun getPropertiesByType(type:PropertyType): List<Property>

    suspend fun getPropertyById(id:String): Property?

    suspend fun searchProperty(name:String): List<Property>?

}