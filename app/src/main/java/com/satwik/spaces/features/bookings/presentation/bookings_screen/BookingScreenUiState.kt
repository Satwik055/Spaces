package com.satwik.spaces.features.bookings.presentation.bookings_screen

import com.satwik.spaces.data.booking.domain.model.BookedProperty

data class BookingScreenUiState(
    val error:String?= null,
    val isLoading:Boolean = false,
    val bookedProperty: List<BookedProperty>? = null
)
