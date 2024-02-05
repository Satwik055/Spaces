package com.satwik.spaces.bookings.domain.model

import com.satwik.spaces.properties.domain.model.Property

data class BookedProperty(
    val checkInDate: String?,
    val checkOutDate: String,
    val property: Property,
)
