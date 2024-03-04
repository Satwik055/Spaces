package com.satwik.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PeopleStore(private val context:Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("people_store")
        private val PEOPLE = stringPreferencesKey("people")
    }

    private val defaultPeopleCount = "2"

    val getPeople: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[PEOPLE] ?: defaultPeopleCount
    }

    suspend fun savePeople(people:String){
        context.dataStore.edit { preferences ->
            preferences[PEOPLE] = people
        }
    }
}