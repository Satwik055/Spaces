package com.satwik.spaces.bookings.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.ktx.toObject
import com.satwik.spaces.authentication.domain.model.User
import com.satwik.spaces.bookings.domain.model.BookedProperty
import com.satwik.spaces.bookings.domain.repository.BookingsRepository
import com.satwik.spaces.core.exceptions.NoBookingsFound
import com.satwik.spaces.core.utils.qualifiers.BookingCollection
import com.satwik.spaces.core.utils.qualifiers.PropertyCollection
import com.satwik.spaces.core.utils.qualifiers.UserCollection
import com.satwik.spaces.payments.domain.model.Booking
import com.satwik.spaces.properties.domain.model.Property
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
                val booking = bookingCollection.document(bookingId).get().await().toObject<Booking>()
                val property = propertyCollection.document(booking!!.propertyId).get().await().toObject<Property>()!!
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

