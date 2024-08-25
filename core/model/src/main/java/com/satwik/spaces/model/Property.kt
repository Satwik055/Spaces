package com.satwik.spaces.model

import com.google.gson.annotations.SerializedName


data class Property(
    val id:Int = 1,
    val name:String = "",
    val address:String = "",
    val description:String = "",
    @SerializedName("image_urls") val imageUrls:List<String> = emptyList(),
    val price:String = "",
    val rating:String = "",
    val people:String = "",
    val floor:String = "",
    @SerializedName("carpet_area") val carpetArea:String = "",
    val type:String? = ""
)
