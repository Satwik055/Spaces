package com.satwik.detail.presentation.detail_screen

data class DetailScreenUiState(
    val propertyState: PropertyState = PropertyState(),
    val checkinDate: String = "",
    val checkoutDate: String = ""
)
