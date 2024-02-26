package com.satwik.booking.di


import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.satwik.booking.data.BookingRepositoryImpl
import com.satwik.booking.domain.repository.BookingsRepository
import com.satwik.di.Tempfour
import com.satwik.di.Tempone
import com.satwik.di.Tempthree
import com.satwik.di.Temptwo
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
        @Tempthree bookingCollectionReference: CollectionReference,
        @Temptwo userCollection: CollectionReference,
        @Tempone propertyCollection: CollectionReference,
        @Tempfour firebaseAuth: FirebaseAuth
    ): BookingsRepository = BookingRepositoryImpl(bookingCollectionReference, userCollection, propertyCollection, firebaseAuth)
}