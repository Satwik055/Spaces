package com.satwik.spaces.properties.presentation.home_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satwik.spaces.core.utils.Resource
import com.satwik.spaces.properties.domain.use_case.get_all_properties.GetAllPropertiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getAllPropertiesUseCase: GetAllPropertiesUseCase,
): ViewModel() {

    private val _state = mutableStateOf(PropertyListState())
    val state:State<PropertyListState> = _state

    init {
        getAllProperties()
    }

    private fun getAllProperties(){
        getAllPropertiesUseCase().onEach {result->
            when(result){
                is Resource.Success-> {
                    _state.value = PropertyListState(properties = result.data?: emptyList())
                }
                is Resource.Error-> {
                    _state.value = PropertyListState(error = result.message?:"An unexpected error occurred")
                }
                is Resource.Loading-> {
                    _state.value = PropertyListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}