package com.satwik.spaces.data.booking.domain.model

import com.satwik.spaces.data.property.domain.model.Property

data class BookedProperty(
    val checkInDate: String?,
    val checkOutDate: String,
    val property: Property,
)
