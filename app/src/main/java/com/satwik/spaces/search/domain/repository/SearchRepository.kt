package com.satwik.spaces.search.domain.repository

import com.satwik.spaces.common.domain.model.Property

interface SearchRepository{
    suspend fun searchProperty(query:String): List<Property>?
}