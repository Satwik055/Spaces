package com.satwik.spaces.authentication.domain.use_case

import com.satwik.spaces.authentication.domain.repository.AuthRepository
import com.satwik.spaces.core.utils.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SignupUseCase @Inject constructor(private val repository: AuthRepository) {
    operator fun invoke(email:String, password:String, username:String) = flow{
        emit(Resource.Loading())
        try{
            emit(Resource.Success(repository.signup(email, password, username)))
        }
        catch (e:Exception){
            emit(Resource.Error(e.localizedMessage?:"Something went wrong"))
            e.printStackTrace()
        }
    }
}