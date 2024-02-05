package com.satwik.spaces.core.di

import android.app.Application
import android.content.Context
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.satwik.spaces.core.utils.Constants
import com.satwik.spaces.core.utils.qualifiers.BookingCollection
import com.satwik.spaces.core.utils.qualifiers.PropertyCollection
import com.satwik.spaces.core.utils.qualifiers.UserCollection
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

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
    fun provideContext(application: Application): Context = application.applicationContext

}