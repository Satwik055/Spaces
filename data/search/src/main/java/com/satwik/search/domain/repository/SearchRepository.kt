package com.satwik.search.domain.repository

import com.satwik.common.Property

interface SearchRepository{
    suspend fun searchProperty(query:String): List<Property>?
}