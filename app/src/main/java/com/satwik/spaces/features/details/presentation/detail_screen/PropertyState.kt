package com.satwik.spaces.features.details.presentation.detail_screen

import com.satwik.spaces.data.property.domain.model.Property

data class PropertyState(
    val isLoading:Boolean = false,
    val property: Property? = null,
    val error: String? = null
)
