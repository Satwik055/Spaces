package com.satwik.spaces.data.booking.domain.repository

import com.satwik.spaces.data.booking.domain.model.BookedProperty

interface BookingsRepository {
    suspend fun getAllBookedProperty():List<BookedProperty>
}