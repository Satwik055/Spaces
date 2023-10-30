package com.satwik.spaces.properties.domain.use_case.search_property

import com.satwik.spaces.core.utils.Resource
import com.satwik.spaces.properties.domain.repository.PropertiesRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchPropertyUseCase @Inject constructor(private val repository: PropertiesRepository) {

    operator fun invoke(name:String)= flow {
        try {
            emit(Resource.Loading())
            val searchResult = repository.searchProperty(name)
            emit(Resource.Success(searchResult))
        }
        catch (e:Exception){
            emit(Resource.Error(e.localizedMessage?:"An unexpected error occurred"))
        }
    }
}