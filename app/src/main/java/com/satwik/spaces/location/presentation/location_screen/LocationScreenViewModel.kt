package com.satwik.spaces.location.presentation.location_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satwik.spaces.core.utils.datastore.DateStore
import com.satwik.spaces.core.utils.datastore.LocationStore
import com.satwik.spaces.core.utils.datastore.PeopleStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationScreenViewModel @Inject constructor(
    private val locationStore: LocationStore,
    private val dateStore: DateStore,
    private val peopleStore: PeopleStore
):ViewModel() {

    fun saveCheckinDate(date:String) = viewModelScope.launch{
        dateStore.saveCheckinDate(date)
    }

    fun saveCheckoutDate(date:String) = viewModelScope.launch{
        dateStore.saveCheckoutDate(date)
    }

    fun saveLocation(location:String) = viewModelScope.launch {
        locationStore.saveLocation(location)
    }

    fun getLocation() = locationStore.getLocation

    fun getPeople() = peopleStore.getPeople

    fun savePeople(people:String) = viewModelScope.launch {
        peopleStore.savePeople(people)
    }

}