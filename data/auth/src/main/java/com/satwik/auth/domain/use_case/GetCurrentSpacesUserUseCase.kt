package com.satwik.auth.domain.use_case

import com.satwik.auth.domain.repository.AuthRepository
import com.satwik.common.User
import javax.inject.Inject

class GetCurrentSpacesUserUseCase @Inject constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(): User {
        return repository.getSpacesCurrentUser()
    }
}