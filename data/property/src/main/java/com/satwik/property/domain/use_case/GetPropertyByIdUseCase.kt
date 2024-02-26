package com.satwik.spaces.data.property.domain.use_case

import com.satwik.spaces.core.utils.Resource
import com.satwik.spaces.data.property.domain.repository.PropertyRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPropertyByIdUseCase @Inject constructor(private val repository: PropertyRepository) {
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