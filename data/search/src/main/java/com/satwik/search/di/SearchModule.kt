package com.satwik.search.di

import com.google.firebase.firestore.CollectionReference
import com.satwik.qualifiers.PropertyCollection
import com.satwik.search.data.repository.SearchRepositoryImpl
import com.satwik.search.domain.repository.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SearchModule {

    @Provides
    @Singleton
    fun provideSearchRepository(@PropertyCollection propertyCollectionReference: CollectionReference): SearchRepository =
        SearchRepositoryImpl(propertyCollectionReference)
}