package com.satwik.spaces.properties.domain.use_case.get_all_properties

import com.satwik.spaces.common.Resource
import com.satwik.spaces.properties.domain.repository.PropertiesRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllPropertiesUseCase @Inject constructor(private val repository: PropertiesRepository) {

    operator fun invoke() = flow{
        try{
            emit(Resource.Loading())
            val properties = repository.getAllProperties()
            emit(Resource.Success(properties))
        }
        catch (e:Exception){
            emit(Resource.Error(e.localizedMessage?:"An error occurred"))
        }
    }
}