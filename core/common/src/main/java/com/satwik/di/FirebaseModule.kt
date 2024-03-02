package com.satwik.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Tempone

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Temptwo

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Tempthree

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Tempfour



@Module
@InstallIn(SingletonComponent::class)
object BookingsModule {

    @Provides
    @Singleton
    @Tempone
    fun providesPropertyCollectionRef(): CollectionReference {
        return Firebase.firestore.collection("Property")
    }
    @Singleton
    @Provides
    @Temptwo
    fun providesUserCollectionRef(): CollectionReference {
        return Firebase.firestore.collection("User")
    }
    @Singleton
    @Provides
    @Tempthree
    fun providesBookingCollectionRef(): CollectionReference {
        return Firebase.firestore.collection("Booking")
    }

    @Provides
    @Singleton
    @Tempfour
    fun provideFirebaseAuth():FirebaseAuth = FirebaseAuth.getInstance()
}