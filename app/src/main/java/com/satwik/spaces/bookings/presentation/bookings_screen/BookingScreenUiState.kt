package com.satwik.spaces.bookings.presentation.bookings_screen

import com.satwik.spaces.bookings.domain.model.BookedProperty

data class BookingScreenUiState(
    val error:String?= null,
    val isLoading:Boolean = false,
    val bookedProperty: List<BookedProperty>? = null
)
