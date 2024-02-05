package com.satwik.spaces.core.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DateStore(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("bookingDates")
        private val CHECKIN_DATE_KEY = stringPreferencesKey("check_in_date")
        private val CHECKOUT_DATE_KEY = stringPreferencesKey("check_out_date")
    }

    val getCheckinDate: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[CHECKIN_DATE_KEY] ?: ""
    }

    val getCheckoutDate: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[CHECKOUT_DATE_KEY] ?: ""
    }

    suspend fun saveCheckinDate(date: String) {
        context.dataStore.edit { preferences ->
            preferences[CHECKIN_DATE_KEY] = date
        }
    }
    suspend fun saveCheckoutDate(date: String) {
        context.dataStore.edit { preferences ->
            preferences[CHECKOUT_DATE_KEY] = date
        }
    }

}