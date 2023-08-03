package com.satwik.spaces.domain.model

import androidx.annotation.DrawableRes

data class Property(
    val id:Int,
    val name:String = "",
    val address:String = "",
    val description:String = "",
    val imageUrls:List<String>,
    val price:String = "",
    val rating:String = "",
    val people:String = "",
    val floor:String = "",
    val carpetArea:String = "",
)
