package com.satwik.spaces.features.explore.presentation.explore_screen.tabs

import com.satwik.spaces.data.property.domain.model.Property

data class TabScreenUIState(
    val isLoading:Boolean = false,
    val properties:List<Property> = emptyList(),
    val error:String = ""
)