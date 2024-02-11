package com.satwik.spaces.explore.di

import com.google.firebase.firestore.CollectionReference
import com.satwik.spaces.core.utils.qualifiers.PropertyCollection
import com.satwik.spaces.explore.data.repository.ExploreRepositoryImpl
import com.satwik.spaces.explore.domain.repository.ExploreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ExploreModule {

    @Provides
    @Singleton
    fun providesExploreRepository(
        @PropertyCollection propertyCollection: CollectionReference,
    ):ExploreRepository{
        return ExploreRepositoryImpl(propertyCollection)
    }
}