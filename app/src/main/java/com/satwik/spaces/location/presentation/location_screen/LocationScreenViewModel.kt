package com.satwik.spaces.location.presentation.location_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satwik.spaces.core.datastore.DateStore
import com.satwik.spaces.core.datastore.LocationStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationScreenViewModel @Inject constructor(
    private val locationStore: LocationStore,
    private val dateStore: DateStore
):ViewModel() {

    fun saveCheckinDate(date:String) = viewModelScope.launch{
        dateStore.saveCheckinDate(date)
    }

    fun saveCheckoutDate(date:String)=  viewModelScope.launch{
        dateStore.saveCheckoutDate(date)
    }

    fun saveLocation(location:String) = viewModelScope.launch {
        locationStore.saveLocation(location)
    }

    fun getLocation() = locationStore.getLocation


}