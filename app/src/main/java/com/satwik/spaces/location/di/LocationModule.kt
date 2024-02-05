package com.satwik.spaces.location.di

import android.content.Context
import com.satwik.spaces.core.utils.DateStore
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
}