package com.satwik.spaces.properties.presentation.search_screen

import com.satwik.spaces.properties.domain.model.Property

data class SearchResultState(
    val isLoading:Boolean = false,
    val searchResult:List<Property> = emptyList(),
    val error: String? = ""
)
