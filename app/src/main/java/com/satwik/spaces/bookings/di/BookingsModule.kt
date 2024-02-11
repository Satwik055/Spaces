package com.satwik.spaces.bookings.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.satwik.spaces.bookings.data.BookingRepositoryImpl
import com.satwik.spaces.bookings.domain.repository.BookingsRepository
import com.satwik.spaces.core.utils.qualifiers.BookingCollection
import com.satwik.spaces.core.utils.qualifiers.PropertyCollection
import com.satwik.spaces.core.utils.qualifiers.UserCollection
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
        firebaseAuth: FirebaseAuth):
            BookingsRepository = BookingRepositoryImpl(bookingCollectionReference, userCollection, propertyCollection, firebaseAuth)
}