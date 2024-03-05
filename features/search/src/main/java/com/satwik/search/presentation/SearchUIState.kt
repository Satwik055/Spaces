package com.satwik.search.presentation

import com.satwik.common.Property

data class SearchUIState(
    val searchResult:List<Property>? = null,
    val error:String? = null,
    val isLoading:Boolean = false
)
