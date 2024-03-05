package com.satwik.property.di

import com.google.firebase.firestore.CollectionReference
import com.satwik.property.data.PropertyRepositoryImpl
import com.satwik.property.domain.repository.PropertyRepository
import com.satwik.qualifiers.PropertyCollection
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
        @PropertyCollection propertyCollection: CollectionReference,
        ): PropertyRepository {
        return PropertyRepositoryImpl(propertyCollection)
    }
}