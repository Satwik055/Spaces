package com.satwik.spaces.core.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocationStore(private val context:Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("location")
        private val LOCATION = stringPreferencesKey("location")
    }

    private val defaultLocation = "Lower Manhattan"

    val getLocation: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[LOCATION] ?: defaultLocation
    }

    suspend fun saveLocation(location:String){
        context.dataStore.edit { preferences ->
            preferences[LOCATION] = location
        }
    }


}