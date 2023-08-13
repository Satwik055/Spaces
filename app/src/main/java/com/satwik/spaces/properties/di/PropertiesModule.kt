package com.satwik.spaces.properties.di

import com.google.firebase.firestore.CollectionReference
import com.satwik.spaces.properties.data.repository.PropertiesRepositoryImpl
import com.satwik.spaces.properties.domain.repository.PropertiesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PropertiesModule {

    @Provides
    @Singleton
    fun providesPropertyRepository(collectionReference: CollectionReference): PropertiesRepository =
        PropertiesRepositoryImpl(collectionReference)


}