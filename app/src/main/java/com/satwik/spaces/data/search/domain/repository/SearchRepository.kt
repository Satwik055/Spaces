package com.satwik.spaces.data.search.domain.repository

import com.satwik.spaces.data.property.domain.model.Property

interface SearchRepository{
    suspend fun searchProperty(query:String): List<Property>?
}