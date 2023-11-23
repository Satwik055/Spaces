package com.satwik.spaces.search.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satwik.spaces.core.utils.Resource
import com.satwik.spaces.search.domain.use_case.search_property.SearchPropertyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    private val searchPropertyUseCase:SearchPropertyUseCase
) :ViewModel(){

    private val _state = mutableStateOf(SearchUIState())
    val state: State<SearchUIState> = _state

    fun searchProperty(query:String){
        searchPropertyUseCase(query = query).onEach {result->
            when(result){
                is Resource.Success ->  _state.value = SearchUIState(searchResult= result.data?: emptyList())
                is Resource.Error -> _state.value = SearchUIState(error = result.message)
                is Resource.Loading ->  _state.value = SearchUIState(isLoading = true)
            }
        }.launchIn(viewModelScope)
    }
}