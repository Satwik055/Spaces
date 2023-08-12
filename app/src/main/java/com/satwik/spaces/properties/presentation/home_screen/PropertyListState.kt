package com.satwik.spaces.properties.presentation.home_screen

import com.satwik.spaces.properties.domain.model.Property

data class PropertyListState(
    val isLoading:Boolean = false,
    val properties:List<Property> = emptyList(),
    val error:String = ""
)
