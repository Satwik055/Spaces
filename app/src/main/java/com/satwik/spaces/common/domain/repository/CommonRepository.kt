package com.satwik.spaces.common.domain.repository

import com.satwik.spaces.common.domain.model.Property
import com.satwik.spaces.common.domain.model.User

interface CommonRepository {
    suspend fun getCurrentSpacesUser(): User
    suspend fun getPropertyById(id:String): Property?
}