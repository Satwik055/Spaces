package com.satwik.spaces.explore.domain.repository

import com.satwik.spaces.common.domain.model.Property
import com.satwik.spaces.core.utils.PropertyType

interface ExploreRepository {
    suspend fun getPropertiesByType(type: PropertyType): List<Property>
}