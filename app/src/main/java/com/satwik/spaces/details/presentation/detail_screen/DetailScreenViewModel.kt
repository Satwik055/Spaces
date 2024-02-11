package com.satwik.spaces.details.presentation.detail_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satwik.spaces.common.domain.use_case.GetPropertyByIdUseCase
import com.satwik.spaces.core.utils.Constants.DETAIL_SCREEN_ARGUMENT_KEY
import com.satwik.spaces.core.utils.Resource
import com.satwik.spaces.core.utils.datastore.DateStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel@Inject constructor(
    private val getPropertyByIdUseCase: GetPropertyByIdUseCase,
    private val dateStore: DateStore,
    savedStateHandle: SavedStateHandle
) :ViewModel() {

    private val _state = mutableStateOf(PropertyState())
    val state:State<PropertyState> = _state

    init {
        savedStateHandle.get<String>(DETAIL_SCREEN_ARGUMENT_KEY)?.let{ getPropertyById(it) }
    }

    fun getCheckinDate() = dateStore.getCheckinDate

    fun getCheckoutDate() = dateStore.getCheckoutDate

    private fun getPropertyById(propertyId: String){
        getPropertyByIdUseCase(propertyId).onEach { result->
            when(result){
                is Resource.Success-> _state.value= PropertyState(property = result.data)

                is Resource.Error-> _state.value= PropertyState(error = result.message?:"An unexpected error occurred")

                is Resource.Loading-> _state.value= PropertyState(isLoading = true)
            }
        }.launchIn(viewModelScope)
    }
}
