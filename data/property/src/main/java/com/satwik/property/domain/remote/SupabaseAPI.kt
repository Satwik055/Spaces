package com.satwik.property.domain.remote

import com.satwik.common.PropertyType
import com.satwik.spaces.model.Property
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SupabaseAPI {

    @GET("/spaces-property-service/v1/property")
    suspend fun getPropertiesByType(
        @Query("type") type: PropertyType,
    ):List<Property>


    @GET("/spaces-property-service/v1/property/{id}")
    suspend fun getPropertyById(@Path("id") id:Int):Property


}