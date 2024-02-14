package com.satwik.spaces.features.explore.presentation.explore_screen.tabs

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satwik.spaces.core.utils.PropertyType
import com.satwik.spaces.core.utils.Resource
import com.satwik.spaces.data.property.domain.use_case.GetPropertiesByTypeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TabScreenViewModel @Inject constructor(
    private val getPropertiesByTypeUseCase: GetPropertiesByTypeUseCase,
) :ViewModel() {

    private val _state = mutableStateOf(TabScreenUIState())
    val state: State<TabScreenUIState> = _state

    fun getPropertiesByType(type:PropertyType){
        getPropertiesByTypeUseCase(type).onEach {result->
            when(result){
                is Resource.Success-> {
                    _state.value = TabScreenUIState(properties = result.data?: emptyList())
                }
                is Resource.Error-> {
                    _state.value = TabScreenUIState(error = result.message?:"An unexpected error occurred")
                }
                is Resource.Loading-> {
                    _state.value = TabScreenUIState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}