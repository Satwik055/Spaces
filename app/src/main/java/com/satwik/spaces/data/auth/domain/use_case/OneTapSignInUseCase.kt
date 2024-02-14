package com.satwik.spaces.data.auth.domain.use_case

import com.satwik.spaces.data.auth.domain.repository.AuthRepository
import com.satwik.spaces.core.utils.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class OneTapSignInUseCase@Inject constructor(private val repository: AuthRepository) {
    operator fun invoke(tokenId:String)= flow {
        try {
            emit(Resource.Success(repository.oneTapSignIn(tokenId)))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Something went wrong"))
        }
    }
}