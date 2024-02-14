package com.satwik.spaces.features.payments.presentation.checkout_screen.states

import com.satwik.spaces.data.property.domain.model.Property

data class PropertyState(
    val isLoading:Boolean = false,
    val error: String? = null,
    val property: Property? = null,


    )
