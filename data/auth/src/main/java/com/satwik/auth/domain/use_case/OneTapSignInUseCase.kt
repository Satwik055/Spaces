package com.satwik.auth.domain.use_case

import com.satwik.auth.domain.repository.AuthRepository
import com.satwik.common.Resource
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