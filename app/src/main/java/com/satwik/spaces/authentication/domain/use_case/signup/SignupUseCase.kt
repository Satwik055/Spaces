package com.satwik.spaces.authentication.domain.use_case.signup

import com.satwik.spaces.authentication.domain.repository.AuthRepository
import com.satwik.spaces.core.utils.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SignupUseCase @Inject constructor(private val authRepository:AuthRepository) {

    operator fun invoke(email:String, password:String) = flow{
        try{
            emit(Resource.Loading())
            val result = authRepository.signup(email, password)
            emit(Resource.Success(result))
        }
        catch (e:Exception){
            emit(Resource.Error(e.localizedMessage?:"Unexpected error occurred"))
        }
    }
}