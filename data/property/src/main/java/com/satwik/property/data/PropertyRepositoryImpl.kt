package com.satwik.property.data

import com.satwik.common.PropertyType
import com.satwik.property.domain.remote.SupabaseAPI
import com.satwik.property.domain.repository.PropertyRepository
import com.satwik.spaces.model.Property
import javax.inject.Inject

class PropertyRepositoryImpl @Inject constructor(
    private val api: SupabaseAPI
): PropertyRepository {

    override suspend fun getPropertyById(id: Int):  Property{
        return api.getPropertyById(id)
    }

    override suspend fun getPropertiesByType(type: PropertyType): List<Property> {
        return api.getPropertiesByType(type)
    }
}