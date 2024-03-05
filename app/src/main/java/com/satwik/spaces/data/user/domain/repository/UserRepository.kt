package com.satwik.spaces.data.user.domain.repository

import com.satwik.common.User

interface UserRepository {
    suspend fun getCurrentSpacesUser(): User
}