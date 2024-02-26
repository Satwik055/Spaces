package com.satwik.booking.presentation

import com.satwik.common.BookedProperty


data class BookingScreenUiState(
    val error:String?= null,
    val isLoading:Boolean = false,
    val bookedProperty: List<BookedProperty>? = null
)
