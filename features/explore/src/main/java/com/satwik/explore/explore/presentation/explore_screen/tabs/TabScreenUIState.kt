package com.satwik.explore.explore.presentation.explore_screen.tabs

import com.satwik.spaces.model.Property


data class TabScreenUIState(
    val isLoading:Boolean = false,
    val properties:List<Property> = emptyList(),
    val error:String = ""
)