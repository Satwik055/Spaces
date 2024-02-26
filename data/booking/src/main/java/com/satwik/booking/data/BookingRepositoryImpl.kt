package com.satwik.booking.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.toObject
import com.satwik.booking.domain.repository.BookingsRepository
import com.satwik.common.BookedProperty
import com.satwik.utils.exceptions.NoBookingsFound
import com.satwik.utils.qualifiers.BookingCollection
import com.satwik.utils.qualifiers.PropertyCollection
import com.satwik.utils.qualifiers.UserCollection
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class BookingRepositoryImpl @Inject constructor(
    @BookingCollection private val bookingCollection:CollectionReference,
    @UserCollection private val userCollection: CollectionReference,
    @PropertyCollection private val propertyCollection: CollectionReference,
    private val firebaseAuth: FirebaseAuth
) : BookingsRepository {

    override suspend fun getAllBookedProperty(): List<BookedProperty> {
        val user = userCollection.document(firebaseAuth.uid!!).get().await()
        val bookedPropertyArray = mutableListOf<BookedProperty>()
        val bookingIdArray = user.get("bookings") as List<String>

        if(bookingIdArray.isEmpty()){
            throw NoBookingsFound()
        }
        else{
            for(bookingId in bookingIdArray){
                val booking = bookingCollection.document(bookingId).get().await().toObject<com.satwik.common.Booking>()
                val property = propertyCollection.document(booking!!.propertyId).get().await().toObject<com.satwik.common.Property>()!!
                val bookedProperty = BookedProperty(
                    checkInDate = booking.checkInDate,
                    checkOutDate = booking.checkOutDate,
                    property = property
                )
                bookedPropertyArray.add(bookedProperty)
            }
        }
        return bookedPropertyArray
    }
}

