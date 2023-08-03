package com.satwik.spaces.di

import androidx.compose.ui.unit.Constraints
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.satwik.spaces.common.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesPropertyRef() = Firebase.firestore.collection(Constants.PROPERTIES)
}