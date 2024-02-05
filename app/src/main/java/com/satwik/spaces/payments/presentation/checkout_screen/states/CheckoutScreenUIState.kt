package com.satwik.spaces.payments.presentation.checkout_screen.states

import com.satwik.spaces.payments.domain.model.Booking
import com.satwik.spaces.properties.domain.model.Property

data class CheckoutScreenUIState(
    val error: String? = null,
    val isLoading: Boolean = false,
    val booking: Booking? = null,
    var property: Property? = null
)
