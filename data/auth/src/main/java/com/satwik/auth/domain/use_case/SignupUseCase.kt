package com.satwik.auth.domain.use_case

import com.satwik.auth.domain.repository.AuthRepository
import com.satwik.common.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SignupUseCase @Inject constructor(private val repository: AuthRepository) {
    operator fun invoke(email:String, password:String, username:String) = flow{
        emit(Resource.Loading())
        try{
            emit(Resource.Success(repository.signup(email, password, username)))
        }
        catch (e:Exception){
            emit(Resource.Error(e.message?:"Something went wrong"))
            e.printStackTrace()
        }
    }
}