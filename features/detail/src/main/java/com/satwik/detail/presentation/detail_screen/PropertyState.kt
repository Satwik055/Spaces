package com.satwik.detail.presentation.detail_screen

import com.satwik.property.domain.model.Property

data class PropertyState(
    val isLoading:Boolean = false,
    val property: Property? = null,
    val error: String = ""
)
