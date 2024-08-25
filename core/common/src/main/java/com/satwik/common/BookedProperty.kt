package com.satwik.common

import com.satwik.spaces.model.Property

data class BookedProperty(
    val checkInDate: String?,
    val checkOutDate: String,
    val property: Property,
)
