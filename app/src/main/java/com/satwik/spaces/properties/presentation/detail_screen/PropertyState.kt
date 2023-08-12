package com.satwik.spaces.properties.presentation.detail_screen

import com.satwik.spaces.properties.domain.model.Property

data class PropertyState(
    val isLoading:Boolean = false,
    val property: Property? = null,
    val error: String? = null
)
