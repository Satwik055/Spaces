package com.satwik.spaces.payments.presentation.checkout_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satwik.spaces.core.utils.Resource
import com.satwik.spaces.payments.domain.use_case.GetCustomerUseCase
import com.satwik.spaces.payments.domain.use_case.InitiatePaymentRequestUseCase
import com.satwik.spaces.payments.presentation.checkout_screen.states.BookingInfoState
import com.satwik.spaces.payments.presentation.checkout_screen.states.PropertyState
import com.satwik.spaces.payments.presentation.checkout_screen.states.PaymentsApiResponseState
import com.satwik.spaces.properties.domain.use_case.get_property_by_id.GetPropertyByIdUseCase
import com.stripe.android.paymentsheet.PaymentSheetResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CheckoutScreenViewModel @Inject constructor(
    private val getPropertyByIdUseCase: GetPropertyByIdUseCase,
    private val initiatePaymentRequestUseCase: InitiatePaymentRequestUseCase,
    private val getCustomerUseCase: GetCustomerUseCase
    ):ViewModel() {

    private val _propertyState = mutableStateOf(PropertyState())
    val propertyState:State<PropertyState> = _propertyState

    private val _bookingInfoState = mutableStateOf(BookingInfoState())
    val bookingInfoState:State<BookingInfoState> = _bookingInfoState

    private val _paymentsApiResponseState = mutableStateOf(PaymentsApiResponseState())
    val paymentsApiResponseState: State<PaymentsApiResponseState> = _paymentsApiResponseState


    init {
        initiatePaymentRequest()
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

//    private fun initiatePaymentRequest(){
//        viewModelScope.launch {
//            Log.d("@@@CustomerId", getCustomerUseCase())
//            initiatePaymentRequestUseCase(getCustomerUseCase()).onEach { response->
//                when(response){
//                    is Resource.Error -> _paymentsApiResponseState.value = PaymentsApiResponseState(error = response.message)
//                    is Resource.Success -> _paymentsApiResponseState.value = PaymentsApiResponseState(data = response.data)
//                    is Resource.Loading -> {}
//                }
//            }
//        }
//    }


    @OptIn(ExperimentalCoroutinesApi::class)
    private fun initiatePaymentRequest(){
        val customerId = viewModelScope.async {
            getCustomerUseCase().id
        }
        customerId.invokeOnCompletion {error ->
            if(error==null){
                initiatePaymentRequestUseCase(customerId.getCompleted()).onEach { response->
                    when(response){
                        is Resource.Error -> _paymentsApiResponseState.value = PaymentsApiResponseState(error = response.message)
                        is Resource.Success -> _paymentsApiResponseState.value = PaymentsApiResponseState(data = response.data)
                        is Resource.Loading -> {}
                    }
                }.launchIn(viewModelScope)
            }
        }
    }


}
