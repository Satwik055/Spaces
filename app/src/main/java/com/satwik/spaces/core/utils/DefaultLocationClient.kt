package com.satwik.spaces.core.utils

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationManager
import com.google.android.gms.location.FusedLocationProviderClient
import com.satwik.spaces.core.utils.extensions.hasLocationPermission
import kotlinx.coroutines.tasks.await

class DefaultLocationClient(
    private val context:Context,
    private val client:FusedLocationProviderClient
):LocationClient{
    @SuppressLint("MissingPermission")
    override suspend fun getLastLocation(): Location {

        val locationManager  = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val isGpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        val isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

        if(!isGpsEnabled && !isNetworkEnabled){
            throw LocationClient.LocationException("Gps is disabled")
        }

        if (!context.hasLocationPermission()){
            throw LocationClient.LocationException("Missing location permission")
        }
        else{
            return client.lastLocation.await()
        }
    }
}