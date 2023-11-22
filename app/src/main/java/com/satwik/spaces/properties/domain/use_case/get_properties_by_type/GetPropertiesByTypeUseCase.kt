package com.satwik.spaces.properties.domain.use_case.get_properties_by_type

import com.satwik.spaces.core.exceptions.NoPropertiesFound
import com.satwik.spaces.core.utils.PropertyType
import com.satwik.spaces.core.utils.Resource
import com.satwik.spaces.properties.domain.repository.PropertiesRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPropertiesByTypeUseCase @Inject constructor(private val repository: PropertiesRepository) {

    operator fun invoke(type:PropertyType) = flow{
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