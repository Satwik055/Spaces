package com.satwik.spaces.core.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PropertyStore(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("property")
        private val PROPERTY_ID = stringPreferencesKey("property_id")
    }

    val getPropertyId: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[PROPERTY_ID] ?: ""
    }

    suspend fun savePropertyId(id:String){
        context.dataStore.edit { preferences ->
            preferences[PROPERTY_ID] = id
        }
    }
}