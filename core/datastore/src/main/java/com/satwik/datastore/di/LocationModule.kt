package com.satwik.datastore.di

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.satwik.datastore.DateStore
import com.satwik.datastore.LocationStore
import com.satwik.datastore.PeopleStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocationModule {

    @RequiresApi(Build.VERSION_CODES.O)
    @Provides
    @Singleton
    fun providesDateStore(context: Context) = DateStore(context)

    @Provides
    @Singleton
    fun providesLocationStore(context:Context) = LocationStore(context)

    @Provides
    @Singleton
    fun providesPeopleStore(context:Context) = PeopleStore(context)
}