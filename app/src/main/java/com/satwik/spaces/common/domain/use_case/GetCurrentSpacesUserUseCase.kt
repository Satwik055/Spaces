package com.satwik.spaces.common.domain.use_case

import com.satwik.spaces.common.domain.model.User
import com.satwik.spaces.common.domain.repository.CommonRepository
import javax.inject.Inject

class GetCurrentSpacesUserUseCase @Inject constructor(private val repository: CommonRepository) {
    suspend operator fun invoke(): User {
        return repository.getCurrentSpacesUser()
    }
}