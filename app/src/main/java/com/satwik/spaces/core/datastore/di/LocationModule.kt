package com.satwik.spaces.core.datastore.di

import android.content.Context
import com.satwik.spaces.core.datastore.DateStore
import com.satwik.spaces.core.datastore.LocationStore
import com.satwik.spaces.core.datastore.PeopleStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocationModule {

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