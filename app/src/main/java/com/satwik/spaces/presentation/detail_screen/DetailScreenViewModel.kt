package com.satwik.spaces.presentation.detail_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satwik.spaces.common.Constants
import com.satwik.spaces.common.Resource
import com.satwik.spaces.domain.use_case.get_property_by_id.GetPropertyByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel@Inject constructor(
    private val getPropertyByIdUseCase: GetPropertyByIdUseCase,
    savedStateHandle: SavedStateHandle
) :ViewModel() {

    private val _state = mutableStateOf(PropertyState())
    val state:State<PropertyState> = _state

    init {
        savedStateHandle.get<String>(Constants.DETAIL_SCREEN_ARGUMENT_KEY)?.let {
                propertyId-> getPropertyById(propertyId)
        }
    }

    private fun getPropertyById(propertyId: String){
        getPropertyByIdUseCase(propertyId).onEach { result->
            when(result){
                is Resource.Success-> {
                    _state.value= PropertyState(property = result.data)
                }
                is Resource.Error-> {
                    _state.value= PropertyState(error = result.message?:"An unexpected error occurred")
                }
                is Resource.Loading->{
                    _state.value= PropertyState(isLoading = true)
                }
            }


        }.launchIn(viewModelScope)
    }


}
