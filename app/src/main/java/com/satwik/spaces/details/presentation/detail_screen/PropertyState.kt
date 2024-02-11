package com.satwik.spaces.details.presentation.detail_screen

import com.satwik.spaces.common.domain.model.Property

data class PropertyState(
    val isLoading:Boolean = false,
    val property: Property? = null,
    val error: String? = null
)
