package com.satwik.spaces.features.details.presentation.detail_screen

data class DetailScreenUiState(
    val propertyState:PropertyState = PropertyState(),
    val checkinDate: String = "",
    val checkoutDate: String = ""
)
