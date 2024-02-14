package com.satwik.spaces.data.user.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.satwik.spaces.core.utils.qualifiers.UserCollection
import com.satwik.spaces.data.user.data.repository.UserRepositoryImpl
import com.satwik.spaces.data.user.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserModule {

    @Provides
    @Singleton
    fun providesCommonRepository(
        firebaseAuth: FirebaseAuth,
        @UserCollection userCollection: CollectionReference,
    ): UserRepository {
        return UserRepositoryImpl(userCollection, firebaseAuth)
    }
}