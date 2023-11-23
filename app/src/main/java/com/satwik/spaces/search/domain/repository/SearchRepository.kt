package com.satwik.spaces.search.domain.repository

import com.satwik.spaces.properties.domain.model.Property

interface SearchRepository{
    suspend fun searchProperty(query:String): List<Property>?
}