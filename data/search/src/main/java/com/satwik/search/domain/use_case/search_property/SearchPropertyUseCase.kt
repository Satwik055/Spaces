package com.satwik.search.domain.use_case.search_property

import com.satwik.common.Resource
import com.satwik.search.domain.repository.SearchRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchPropertyUseCase @Inject constructor(private val repository: SearchRepository) {
    operator fun invoke(query:String)= flow{
        try{
            emit(Resource.Loading())
            val searchResult = repository.searchProperty(query)
            emit(Resource.Success(searchResult))

        }
        catch (e:Exception){
           emit(Resource.Error(e.localizedMessage?:"Something went wrong"))
        }
    }
}