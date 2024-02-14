package com.satwik.spaces.data.property.di

import android.content.Context
import com.google.firebase.firestore.CollectionReference
import com.satwik.spaces.core.datastore.PropertyStore
import com.satwik.spaces.core.utils.qualifiers.PropertyCollection
import com.satwik.spaces.data.property.data.PropertyRepositoryImpl
import com.satwik.spaces.data.property.domain.repository.PropertyRepository
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
        @PropertyCollection propertyCollection:CollectionReference,
        ): PropertyRepository {
        return PropertyRepositoryImpl(propertyCollection)
    }

    @Provides
    @Singleton
    fun providesPropertyStore(context: Context)= PropertyStore(context)
}