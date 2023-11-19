package com.satwik.spaces.properties.presentation.search_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satwik.spaces.core.utils.Resource
import com.satwik.spaces.properties.domain.use_case.search_property.SearchPropertyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    private val searchPropertyUseCase: SearchPropertyUseCase,
):ViewModel(){
    private val _state = mutableStateOf(SearchResultState())
    val state: State<SearchResultState> = _state

    init {
        searchProperty("Binari Apple")
    }

    private fun searchProperty(name:String){
        searchPropertyUseCase(name).onEach {result->
            when(result){
                is Resource.Success-> {
                    _state.value = SearchResultState(searchResult = result.data?: emptyList())
                }
                is Resource.Error-> {
                    _state.value = SearchResultState(error = result.message?:"")
                }
                is Resource.Loading-> {
                    _state.value = SearchResultState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }
}

