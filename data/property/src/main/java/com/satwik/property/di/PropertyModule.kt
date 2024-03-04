package com.satwik.property.di

import com.google.firebase.firestore.CollectionReference
import com.satwik.di.Tempone
import com.satwik.property.data.PropertyRepositoryImpl
import com.satwik.property.domain.repository.PropertyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object PropertyModule {

    @Provides
    @Singleton
    fun providesPropertyRepository(
        @Tempone propertyCollection: CollectionReference,
        ): PropertyRepository {
        return PropertyRepositoryImpl(propertyCollection)
    }
}