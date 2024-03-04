package com.satwik.detail.presentation.detail_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satwik.common.Constants.DETAIL_SCREEN_ARGUMENT_KEY
import com.satwik.common.Resource
import com.satwik.datastore.DateStore
import com.satwik.property.domain.use_case.GetPropertyByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class DetailScreenViewModel@Inject constructor(
    private val getPropertyByIdUseCase: GetPropertyByIdUseCase,
    private val dateStore: DateStore,
    savedStateHandle: SavedStateHandle
) :ViewModel() {

    private val _state= mutableStateOf(DetailScreenUiState())
    val state: State<DetailScreenUiState> = _state


    init {
        savedStateHandle.get<String>(DETAIL_SCREEN_ARGUMENT_KEY)?.let {
            loadDataIntoStates(it)
        }
    }

    private fun loadDataIntoStates(propertyId: String){
        getBookingDates()
        getPropertyById(propertyId)
    }


    private fun getBookingDates(){
        viewModelScope.launch {
            dateStore.getCheckinDate.collect{
                _state.value = _state.value.copy(checkinDate = it)
            }
        }
        viewModelScope.launch {
            dateStore.getCheckoutDate.collect{
                _state.value = _state.value.copy(checkoutDate = it)
            }
        }
    }

    private fun getPropertyById(propertyId: String) {
        getPropertyByIdUseCase(propertyId).onEach { result ->
            when (result) {
                is Resource.Success -> _state.value =
                    _state.value.copy(propertyState = PropertyState(property = result.data))

                is Resource.Error -> _state.value =
                    _state.value.copy(propertyState = PropertyState(error = result.message))

                is Resource.Loading -> _state.value =
                    _state.value.copy(propertyState = PropertyState(isLoading = true))
            }
        }.launchIn(viewModelScope)
    }
}
