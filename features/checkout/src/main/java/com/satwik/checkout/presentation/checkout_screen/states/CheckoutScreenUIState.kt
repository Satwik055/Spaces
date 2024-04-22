package com.satwik.checkout.presentation.checkout_screen.states

import com.satwik.common.Booking
import com.satwik.property.domain.model.Property

data class CheckoutScreenUIState(
    val error: String? = null,
    val isLoading: Boolean = false,
    val booking: Booking? = null,
    var property: Property? = null
)
