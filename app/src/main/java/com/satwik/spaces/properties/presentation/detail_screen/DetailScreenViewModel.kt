package com.satwik.spaces.properties.presentation.detail_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satwik.spaces.core.utils.Constants
import com.satwik.spaces.core.utils.datastore.DateStore
import com.satwik.spaces.core.utils.datastore.PropertyStore
import com.satwik.spaces.core.utils.Resource
import com.satwik.spaces.properties.domain.use_case.get_property_by_id.GetPropertyByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel@Inject constructor(
    private val getPropertyByIdUseCase: GetPropertyByIdUseCase,
    private val dateStore: DateStore,
    private val propertyStore: PropertyStore,
) :ViewModel() {

    private val _state = mutableStateOf(PropertyState())
    val state:State<PropertyState> = _state


    init {
        getPropertyById(getPropertyIdFromDataStore())
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

    private fun getPropertyIdFromDataStore():String{
        val propertyId = mutableStateOf("")
        viewModelScope.launch {
            propertyStore.getPropertyId.collect{
                propertyId.value = it
            }
        }
        return propertyId.value
    }

}
