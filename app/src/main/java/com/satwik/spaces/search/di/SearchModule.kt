package com.satwik.spaces.search.di

import com.google.firebase.firestore.CollectionReference
import com.satwik.spaces.search.data.repository.SearchRepositoryImpl
import com.satwik.spaces.search.domain.repository.SearchRepository
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
    fun provideSearchRepository(collectionReference: CollectionReference): SearchRepository =
        SearchRepositoryImpl(collectionReference)
}