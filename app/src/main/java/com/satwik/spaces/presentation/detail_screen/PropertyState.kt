package com.satwik.spaces.presentation.detail_screen

import com.satwik.spaces.domain.model.Property

data class PropertyState(
    val isLoading:Boolean = false,
    val property: Property? = null,
    val error: String? = null
)
