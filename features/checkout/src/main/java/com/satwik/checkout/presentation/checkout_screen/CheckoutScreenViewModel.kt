package com.satwik.checkout.presentation.checkout_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FieldValue
import com.satwik.checkout.presentation.checkout_screen.states.CheckoutScreenUIState
import com.satwik.checkout.presentation.checkout_screen.states.PaymentsApiResponseState
import com.satwik.checkout.presentation.checkout_screen.states.PropertyState
import com.satwik.common.Booking
import com.satwik.common.Constants.CHECKOUT_SCREEN_ARGUMENT_KEY
import com.satwik.common.Resource
import com.satwik.datastore.DateStore
import com.satwik.datastore.PeopleStore
import com.satwik.payment.domain.use_case.GetCustomerUseCase
import com.satwik.payment.domain.use_case.InitiatePaymentRequestUseCase
import com.satwik.property.domain.use_case.GetPropertyByIdUseCase
import com.satwik.qualifiers.BookingCollection
import com.satwik.qualifiers.UserCollection
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class CheckoutScreenViewModel @Inject constructor(
    private val getPropertyByIdUseCase: GetPropertyByIdUseCase,
    private val initiatePaymentRequestUseCase: InitiatePaymentRequestUseCase,
    private val getCustomerUseCase: GetCustomerUseCase,
    @BookingCollection private val bookingCollectionReference: CollectionReference,
    @UserCollection private val userCollection: CollectionReference,
    private val firebaseAuth: FirebaseAuth,
    private val dateStore: DateStore,
    private val peopleStore: PeopleStore,
    savedStateHandle: SavedStateHandle
    ):ViewModel() {

    private val _checkoutScreenUIState = mutableStateOf(CheckoutScreenUIState())
    val checkoutScreenUIState:State<CheckoutScreenUIState> = _checkoutScreenUIState

    private val _paymentsApiResponseState = mutableStateOf(PaymentsApiResponseState())
    val paymentsApiResponseState: State<PaymentsApiResponseState> = _paymentsApiResponseState

    init {
        savedStateHandle.get<String>(CHECKOUT_SCREEN_ARGUMENT_KEY)?.let { propertyId->
            initiateBooking(
                uid = firebaseAuth.uid!!,
                checkinDate = getCheckinDateFromDataStore(),
                checkoutDate = getCheckoutDateFromDataStore(),
                propertyId = propertyId,
                people = getPeopleFromDataStore()
            )
        }
    }

    private fun getCheckinDateFromDataStore(): String {
        val checkinDate = mutableStateOf("")
        viewModelScope.launch {
            dateStore.getCheckinDate.collect{
                checkinDate.value = it
            }
        }
        return checkinDate.value
    }

    private fun getCheckoutDateFromDataStore(): String {
        val checkoutDate = mutableStateOf("")
        viewModelScope.launch {
            dateStore.getCheckoutDate.collect{
                checkoutDate.value = it
            }
        }

        return checkoutDate.value
    }

    private fun getPeopleFromDataStore():String{
        val peopleCount = mutableStateOf("")
        viewModelScope.launch {
            peopleStore.getPeople.collect{
                peopleCount.value = it
            }
        }
        return peopleCount.value
    }

    private fun initiateBooking(uid:String, checkinDate:String,checkoutDate:String, propertyId:String, people:String){

        val booking = Booking(
            uid = uid,
            checkInDate = checkinDate,
            checkOutDate = checkoutDate,
            propertyId = propertyId,
            people = people
        )
        _checkoutScreenUIState.value = CheckoutScreenUIState(booking = booking)


        getPropertyByIdUseCase(propertyId).onEach { result->
            when(result){
                is Resource.Success->
                    _checkoutScreenUIState.value = _checkoutScreenUIState.value.copy(propertyState = PropertyState(property = result.data))

                is Resource.Error->
                    _checkoutScreenUIState.value =_checkoutScreenUIState.value.copy(propertyState = PropertyState(error = result.message?:"An unexpected error occurred"))

                is Resource.Loading->
                    _checkoutScreenUIState.value = _checkoutScreenUIState.value.copy(propertyState = PropertyState(isLoading = true))
            }
        }.launchIn(viewModelScope)
    }

    fun completeBooking(){
        val docId = bookingCollectionReference.document().id
        bookingCollectionReference.document(docId).set(checkoutScreenUIState.value.booking!!)
        userCollection.document(firebaseAuth.currentUser!!.uid).update("bookings", FieldValue.arrayUnion(docId))
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    fun initiatePaymentRequest(amount:String){
        val customerId = viewModelScope.async {
            getCustomerUseCase().id
        }
        customerId.invokeOnCompletion {error ->
            if(error==null){
                initiatePaymentRequestUseCase(customerId.getCompleted(), amount).onEach { response->
                    when(response){
                        is Resource.Error -> _paymentsApiResponseState.value = PaymentsApiResponseState(error = response.message.toString())
                        is Resource.Success -> _paymentsApiResponseState.value = PaymentsApiResponseState(data = response.data)
                        is Resource.Loading -> {}
                    }
                }.launchIn(viewModelScope)
            }
        }
    }
}
