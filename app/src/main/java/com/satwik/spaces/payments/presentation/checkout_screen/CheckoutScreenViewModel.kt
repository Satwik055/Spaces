package com.satwik.spaces.payments.presentation.checkout_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satwik.spaces.core.utils.Resource
import com.satwik.spaces.properties.common.Constants
import com.satwik.spaces.properties.common.Constants.CHECKOUT_SCREEN_ARGUMENT_KEYS
import com.satwik.spaces.properties.domain.use_case.get_property_by_id.GetPropertyByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import okhttp3.internal.toImmutableList
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class CheckoutScreenViewModel @Inject constructor(
    private val getPropertyByIdUseCase: GetPropertyByIdUseCase,
    savedStateHandle: SavedStateHandle

):ViewModel() {

    private val _propertyState = mutableStateOf(PropertyState())
    val propertyState:State<PropertyState> = _propertyState

    private val _bookingInfoState = mutableStateOf(BookingInfoState())
    val bookingInfoState:State<BookingInfoState> = _bookingInfoState

    init {
        //savedStateHandle.get<List<String>>(CHECKOUT_SCREEN_ARGUMENT_KEYS)?.let { arguments-> }

        proceedToCheckout(
            propertyId = "k3PPYRwNY8RC7qzBLG46",
            startDate = "24 Mar 2011",
            endDate = " 31 Mar 2011",
            people = "9"
        )
    }
    private fun proceedToCheckout(
        propertyId:String,
        startDate:String,
        endDate:String,
        people:String
    ){

        _bookingInfoState.value = BookingInfoState(startDate = startDate, endDate = endDate, people = people)

        getPropertyByIdUseCase(propertyId).onEach { result->
            when(result){
                is Resource.Success-> _propertyState.value= PropertyState(property = result.data)

                is Resource.Error-> _propertyState.value= PropertyState(error = result.message?:"An unexpected error occurred")

                is Resource.Loading-> _propertyState.value= PropertyState(isLoading = true)
            }
        }.launchIn(viewModelScope)


    }

}