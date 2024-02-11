package com.satwik.spaces.common.domain.use_case

import com.satwik.spaces.common.domain.repository.CommonRepository
import com.satwik.spaces.core.utils.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPropertyByIdUseCase @Inject constructor(private val repository: CommonRepository) {
    operator fun invoke(propertyId:String) = flow{
        try{
            emit(Resource.Loading())
            val property= repository.getPropertyById(propertyId)
            emit(Resource.Success(property))
        }
        catch (e:Exception){
            emit(Resource.Error(e.localizedMessage?:"An unexpected error occurred"))
        }
    }
}