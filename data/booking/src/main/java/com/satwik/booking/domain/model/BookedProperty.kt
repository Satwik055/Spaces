package com.satwik.booking.domain.model

data class BookedProperty(
    val checkInDate: String?,
    val checkOutDate: String,
    val property: com.satwik.common.Property,
)
