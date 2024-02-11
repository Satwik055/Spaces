package com.satwik.spaces.common.di

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.satwik.spaces.common.data.CommonRepositoryImpl
import com.satwik.spaces.common.domain.repository.CommonRepository
import com.satwik.spaces.core.utils.datastore.PropertyStore
import com.satwik.spaces.core.utils.qualifiers.PropertyCollection
import com.satwik.spaces.core.utils.qualifiers.UserCollection
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CommonModule {

    @Provides
    @Singleton
    fun providesCommonRepository(
        firebaseAuth: FirebaseAuth,
        @UserCollection userCollection: CollectionReference,
        @PropertyCollection propertyCollection:CollectionReference,
        ): CommonRepository {
        return CommonRepositoryImpl(userCollection,propertyCollection, firebaseAuth)
    }

    @Provides
    @Singleton
    fun providesPropertyStore(context: Context)= PropertyStore(context)
}