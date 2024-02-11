package com.satwik.spaces.explore.domain.use_case

import com.satwik.spaces.core.utils.PropertyType
import com.satwik.spaces.core.utils.Resource
import com.satwik.spaces.explore.domain.repository.ExploreRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class GetPropertiesByTypeUseCase @Inject constructor(private val repository: ExploreRepository){
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