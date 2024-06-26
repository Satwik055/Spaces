package com.satwik.booking.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satwik.booking.domain.use_case.GetAllBookingsUseCase
import com.satwik.common.Resource

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class BookingScreenViewModel @Inject constructor(
    private val getAllBookingsUseCase: GetAllBookingsUseCase,
):ViewModel() {

    private val _state = mutableStateOf(BookingScreenUiState())
    val state: State<BookingScreenUiState> = _state

    init{
        getAllBookings()
    }

    private fun getAllBookings(){
        getAllBookingsUseCase().onEach {result->

            when(result){
                is Resource.Success -> _state.value = BookingScreenUiState(bookedProperty = result.data)
                is Resource.Error -> _state.value = BookingScreenUiState(error = result.message)
                is Resource.Loading -> _state.value = BookingScreenUiState(isLoading = true)
            }
        }.launchIn(viewModelScope)
    }
}