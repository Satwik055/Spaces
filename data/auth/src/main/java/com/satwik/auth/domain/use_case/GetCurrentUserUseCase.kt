package com.satwik.auth.domain.use_case

import com.satwik.auth.domain.model.User
import com.satwik.auth.domain.repository.AuthRepository
import javax.inject.Inject

class GetCurrentUserUseCase @Inject constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(): User {
        return repository.getCurrentUser()
    }
}