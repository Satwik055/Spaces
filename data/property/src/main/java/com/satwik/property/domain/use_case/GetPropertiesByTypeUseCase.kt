package com.satwik.property.domain.use_case

import com.satwik.common.PropertyType
import com.satwik.common.Resource
import com.satwik.property.domain.repository.PropertyRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class GetPropertiesByTypeUseCase @Inject constructor(private val repository: PropertyRepository){
    operator fun invoke(type: PropertyType) = flow{
        try{
            emit(Resource.Loading())
            val properties = repository.getPropertiesByType(type)
            emit(Resource.Success(properties))
        }
        catch (e:Exception){
            emit(Resource.Error(e.localizedMessage?:"An error occurred"))
        }
    }
}