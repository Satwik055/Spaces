package com.satwik.spaces.search.presentation

import com.satwik.spaces.properties.domain.model.Property

data class SearchUIState(
    val searchResult:List<Property>? = null,
    val error:String? = null,
    val isLoading:Boolean = false
)
