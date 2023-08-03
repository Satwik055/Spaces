package com.satwik.spaces.domain.repository

import com.satwik.spaces.domain.model.Property
import kotlinx.coroutines.flow.Flow


interface PropertiesRepository{
    suspend fun getPropertiesFromFirestore(): List<Property>
}