package com.satwik.spaces.properties.domain.model

data class Property(
    val id:String = "",
    val name:String = "",
    val address:String = "",
    val description:String = "",
    val imageUrls:List<String> = emptyList(),
    val price:String = "",
    val rating:String = "",
    val people:String = "",
    val floor:String = "",
    val carpetArea:String = "",
    val type:String? = ""
)
