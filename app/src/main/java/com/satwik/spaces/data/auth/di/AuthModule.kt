package com.satwik.spaces.data.auth.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.satwik.spaces.data.auth.data.repository.AuthRepositoryImpl
import com.satwik.spaces.data.auth.domain.repository.AuthRepository
import com.satwik.spaces.core.utils.qualifiers.UserCollection
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth():FirebaseAuth = FirebaseAuth.getInstance()

    @Singleton
    @Provides
    fun provideAuthRepository(
        @UserCollection userCollectionReference: CollectionReference,
        auth:FirebaseAuth
    ): AuthRepository = AuthRepositoryImpl(userCollectionReference, auth)

}