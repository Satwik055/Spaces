package com.satwik.spaces.payments.presentation.checkout_screen.states

import com.satwik.spaces.properties.domain.model.Property

data class PropertyState(
    val isLoading:Boolean = false,
    val error: String? = null,
    val property: Property? = null,


)
