package com.satwik.spaces.core.utils

import android.location.Location

interface LocationClient {
    suspend fun getLastLocation():Location
    class LocationException(message:String):Exception()
}