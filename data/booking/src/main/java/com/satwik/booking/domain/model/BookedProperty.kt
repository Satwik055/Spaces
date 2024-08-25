package com.satwik.booking.domain.model

import com.satwik.spaces.model.Property

data class BookedProperty(
    val checkInDate: String?,
    val checkOutDate: String,
    val property: Property,
)
