package com.satwik.common

data class BookedProperty(
    val checkInDate: String?,
    val checkOutDate: String,
    val property: com.satwik.common.Property,
)
