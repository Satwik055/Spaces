package com.satwik.spaces.properties.presentation.home_screen.tabs

import com.satwik.spaces.properties.domain.model.Property

data class TabScreenUIState(
    val isLoading:Boolean = false,
    val properties:List<Property> = emptyList(),
    val error:String = ""
)