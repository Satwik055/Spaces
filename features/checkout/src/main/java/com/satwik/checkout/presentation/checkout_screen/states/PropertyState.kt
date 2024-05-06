package com.satwik.checkout.presentation.checkout_screen.states

import com.satwik.property.domain.model.Property

data class PropertyState(
    val isLoading:Boolean = false,
    val error: String = "",
    val property: Property? = null,


    )
