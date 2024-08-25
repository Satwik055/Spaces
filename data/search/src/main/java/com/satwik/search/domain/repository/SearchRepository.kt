package com.satwik.search.domain.repository

import com.satwik.spaces.model.Property

interface SearchRepository{
    suspend fun searchProperty(query:String): List<Property>?
}