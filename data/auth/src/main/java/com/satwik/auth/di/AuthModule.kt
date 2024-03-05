package com.satwik.auth.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.satwik.auth.data.repository.AuthRepositoryImpl
import com.satwik.auth.domain.repository.AuthRepository
import com.satwik.qualifiers.UserCollection
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Singleton
    @Provides
    fun provideAuthRepository(
        @UserCollection userCollectionReference: CollectionReference,
        auth:FirebaseAuth
    ): AuthRepository = AuthRepositoryImpl(userCollectionReference, auth)

}