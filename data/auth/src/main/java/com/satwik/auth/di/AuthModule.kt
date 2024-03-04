package com.satwik.auth.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.satwik.auth.data.repository.AuthRepositoryImpl
import com.satwik.auth.domain.repository.AuthRepository
import com.satwik.di.Temptwo
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
        @Temptwo userCollectionReference: CollectionReference,
        auth:FirebaseAuth
    ): AuthRepository = AuthRepositoryImpl(userCollectionReference, auth)

}