package com.satwik.spaces.properties.domain.use_case.get_property_by_id

import com.satwik.spaces.core.utils.Resource
import com.satwik.spaces.properties.domain.repository.PropertiesRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPropertyByIdUseCase  @Inject constructor(private val repository: PropertiesRepository) {

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