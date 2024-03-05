package com.satwik.booking.di


import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.satwik.booking.data.BookingRepositoryImpl
import com.satwik.booking.domain.repository.BookingsRepository
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
    fun providesBookingRepository(
        @BookingCollection bookingCollectionReference: CollectionReference,
        @UserCollection userCollection: CollectionReference,
        @PropertyCollection propertyCollection: CollectionReference,
        firebaseAuth: FirebaseAuth
    ): BookingsRepository = BookingRepositoryImpl(bookingCollectionReference, userCollection, propertyCollection, firebaseAuth)
}