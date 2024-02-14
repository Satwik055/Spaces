package com.satwik.spaces.features.search.presentation

import com.satwik.spaces.data.property.domain.model.Property

data class SearchUIState(
    val searchResult:List<Property>? = null,
    val error:String? = null,
    val isLoading:Boolean = false
)
