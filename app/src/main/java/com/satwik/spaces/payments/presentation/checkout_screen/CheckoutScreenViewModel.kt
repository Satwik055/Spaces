package com.satwik.spaces.payments.presentation.checkout_screen

import android.content.Context
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.datastore.dataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FieldValue
import com.satwik.spaces.core.utils.DateStore
import com.satwik.spaces.core.utils.Resource
import com.satwik.spaces.core.utils.qualifiers.BookingCollection
import com.satwik.spaces.core.utils.qualifiers.UserCollection
import com.satwik.spaces.payments.domain.model.Booking
import com.satwik.spaces.payments.domain.use_case.GetCustomerUseCase
import com.satwik.spaces.payments.domain.use_case.InitiatePaymentRequestUseCase
import com.satwik.spaces.payments.presentation.checkout_screen.states.CheckoutScreenUIState
import com.satwik.spaces.payments.presentation.checkout_screen.states.PaymentsApiResponseState
import com.satwik.spaces.properties.domain.use_case.get_property_by_id.GetPropertyByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class CheckoutScreenViewModel @Inject constructor(
    private val getPropertyByIdUseCase: GetPropertyByIdUseCase,
    private val initiatePaymentRequestUseCase: InitiatePaymentRequestUseCase,
    private val getCustomerUseCase: GetCustomerUseCase,
    @BookingCollection private val bookingCollectionReference: CollectionReference,
    @UserCollection private val userCollection: CollectionReference,
    private val firebaseAuth: FirebaseAuth,
    context: Context
    ):ViewModel() {

    private val _checkoutScreenUIState = mutableStateOf(CheckoutScreenUIState())
    val bookingState:State<CheckoutScreenUIState> = _checkoutScreenUIState

    private val _paymentsApiResponseState = mutableStateOf(PaymentsApiResponseState())
    val paymentsApiResponseState: State<PaymentsApiResponseState> = _paymentsApiResponseState

    private val dateStore:DateStore = DateStore(context)
    init {
        initiatePaymentRequest("9000000")
        initiateBooking(
            uid = firebaseAuth.currentUser!!.uid,
            checkinDate = "23 Mar 23",
            checkoutDate = "24 Mar 27",
            propertyId = "k3PPYRwNY8RC7qzBLG46"
        )
    }

    private fun initiateBooking(uid:String, checkinDate:String,checkoutDate:String, propertyId:String){

        val booking = Booking(
            uid = uid,
            checkInDate = checkinDate,
            checkOutDate = checkoutDate,
            propertyId = propertyId
        )
        _checkoutScreenUIState.value = CheckoutScreenUIState(booking = booking)


        getPropertyByIdUseCase(propertyId).onEach { result->
            when(result){
                is Resource.Success->
                    _checkoutScreenUIState.value = _checkoutScreenUIState.value.copy(property = result.data)

                is Resource.Error->
                    _checkoutScreenUIState.value =_checkoutScreenUIState.value.copy(error = result.message?:"An unexpected error occurred")

                is Resource.Loading->
                    _checkoutScreenUIState.value = _checkoutScreenUIState.value.copy(isLoading = true)
            }
        }.launchIn(viewModelScope)
    }

    fun completeBooking(){
        val docId = bookingCollectionReference.document().id
        bookingCollectionReference.document(docId).set(bookingState.value.booking!!)
        userCollection.document(firebaseAuth.currentUser!!.uid).update("bookings", FieldValue.arrayUnion(docId))
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun initiatePaymentRequest(amount:String){
        val customerId = viewModelScope.async {
            getCustomerUseCase().id
        }
        customerId.invokeOnCompletion {error ->
            if(error==null){
                initiatePaymentRequestUseCase(customerId.getCompleted(), amount).onEach { response->
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
