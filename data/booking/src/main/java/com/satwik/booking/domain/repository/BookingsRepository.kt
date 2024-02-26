package com.satwik.booking.domain.repository

import com.satwik.common.BookedProperty


interface BookingsRepository {
    suspend fun getAllBookedProperty():List<BookedProperty>
}