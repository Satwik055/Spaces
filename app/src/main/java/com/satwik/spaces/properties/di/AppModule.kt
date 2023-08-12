package com.satwik.spaces.properties.di

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.satwik.spaces.properties.common.Constants
import com.satwik.spaces.properties.data.repository.PropertiesRepositoryImpl
import com.satwik.spaces.properties.domain.repository.PropertiesRepository
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
    fun providesCollectionRef(): CollectionReference {
        return Firebase.firestore.collection(Constants.PROPERTIES)
    }

    @Provides
    @Singleton
    fun providesPropertyRepository(collectionReference: CollectionReference): PropertiesRepository {
        return PropertiesRepositoryImpl(collectionReference)
    }

}