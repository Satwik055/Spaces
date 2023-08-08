package com.satwik.spaces.presentation.home_screen

import com.satwik.spaces.domain.model.Property

data class PropertyListState(
    val isLoading:Boolean = false,
    val properties:List<Property> = emptyList(),
    val error:String= ""
)
