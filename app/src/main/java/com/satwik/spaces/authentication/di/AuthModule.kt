package com.satwik.spaces.authentication.di

import com.google.firebase.auth.FirebaseAuth
import com.satwik.spaces.authentication.data.repository.AuthRepositoryImpl
import com.satwik.spaces.authentication.domain.MockAuthRepo
import com.satwik.spaces.authentication.domain.MockAuthRepoImpl
import com.satwik.spaces.authentication.domain.repository.AuthRepository
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

    @Provides
    @Singleton
    fun provideAuthRepository(auth:FirebaseAuth):AuthRepository = AuthRepositoryImpl(auth)

    @Provides
    @Singleton
    fun provideMockAuthRepository(auth:FirebaseAuth):MockAuthRepo = MockAuthRepoImpl(auth)

}