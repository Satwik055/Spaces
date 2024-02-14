package com.satwik.spaces.data.user.domain.repository

import com.satwik.spaces.data.auth.domain.model.User

interface UserRepository {
    suspend fun getCurrentSpacesUser(): User

}