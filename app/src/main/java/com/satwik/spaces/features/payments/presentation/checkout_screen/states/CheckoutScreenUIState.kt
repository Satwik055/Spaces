package com.satwik.spaces.features.payments.presentation.checkout_screen.states

import com.satwik.spaces.data.payment.domain.model.Booking
import com.satwik.spaces.data.property.domain.model.Property

data class CheckoutScreenUIState(
    val error: String? = null,
    val isLoading: Boolean = false,
    val booking: Booking? = null,
    var property: Property? = null
)
