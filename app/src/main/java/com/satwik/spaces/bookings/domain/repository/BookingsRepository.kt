package com.satwik.spaces.bookings.domain.repository

import com.satwik.spaces.bookings.domain.model.BookedProperty
import com.satwik.spaces.payments.domain.model.Booking

interface BookingsRepository {
    suspend fun getAllBookedProperty():List<BookedProperty>
}