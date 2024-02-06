package com.satwik.spaces.properties.di

import android.content.Context
import com.google.firebase.firestore.CollectionReference
import com.satwik.spaces.core.datastore.PropertyStore
import com.satwik.spaces.core.utils.qualifiers.PropertyCollection
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
    fun providesPropertyRepository(@PropertyCollection propertyCollectionReference: CollectionReference): PropertiesRepository =
        PropertiesRepositoryImpl(propertyCollectionReference)

    @Provides
    @Singleton
    fun providesPropertyStore(context: Context)= PropertyStore(context)
}