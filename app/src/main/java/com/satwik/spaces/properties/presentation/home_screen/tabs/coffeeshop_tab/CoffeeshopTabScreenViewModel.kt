package com.satwik.spaces.properties.presentation.home_screen.tabs.coffeeshop_tab

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satwik.spaces.core.utils.Resource
import com.satwik.spaces.properties.domain.use_case.get_properties_by_type.GetPropertiesByTypeUseCase
import com.satwik.spaces.properties.presentation.home_screen.tabs.TabScreenUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoffeeshopTabScreenViewModel @Inject constructor(
    private val getPropertiesByTypeUseCase: GetPropertiesByTypeUseCase,
) :ViewModel() {

    private val _state = mutableStateOf(TabScreenUIState())
    val state: State<TabScreenUIState> = _state

    init {
        getPropertiesByType("workspace")
    }

    private fun getPropertiesByType(type:String){
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