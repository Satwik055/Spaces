package com.satwik.auth.domain.use_case

import com.satwik.auth.domain.repository.AuthRepository
import com.satwik.common.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: AuthRepository) {
    operator fun invoke(email:String, password:String) = flow{
        emit(Resource.Loading())

        if(password.length<=8){
            emit(Resource.Error("Password too short"))
        }
        try{
            emit(Resource.Success(repository.login(email, password)))
        }
        catch (e:Exception){
            emit(Resource.Error(e.localizedMessage?:"Something went wrong"))
            e.printStackTrace()
        }
    }
}