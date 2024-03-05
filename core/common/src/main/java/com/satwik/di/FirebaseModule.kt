package com.satwik.di

import android.app.Application
import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.satwik.common.Constants
import com.satwik.qualifiers.BookingCollection
import com.satwik.qualifiers.PropertyCollection
import com.satwik.qualifiers.UserCollection
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object BookingsModule {

    @Provides
    @Singleton
    @PropertyCollection
    fun providesPropertyCollectionRef(): CollectionReference {
        return Firebase.firestore.collection(Constants.PROPERTIES)
    }
    @Singleton
    @Provides
    @UserCollection
    fun providesUserCollectionRef(): CollectionReference {
        return Firebase.firestore.collection("User")
    }
    @Singleton
    @Provides
    @BookingCollection
    fun providesBookingCollectionRef(): CollectionReference {
        return Firebase.firestore.collection("Booking")
    }

    @Provides
    @Singleton
    fun provideFirebaseAuth():FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideContext(application: Application): Context = application.applicationContext
}