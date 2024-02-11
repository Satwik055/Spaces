package com.satwik.spaces.search.presentation

import com.satwik.spaces.common.domain.model.Property

data class SearchUIState(
    val searchResult:List<Property>? = null,
    val error:String? = null,
    val isLoading:Boolean = false
)
