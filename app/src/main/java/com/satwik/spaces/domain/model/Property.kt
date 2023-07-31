package com.satwik.spaces.domain.model

import androidx.annotation.DrawableRes

data class Property(
    val name:String = "",
    val address:String = "",
    val imageUrls:ArrayList<String> = ArrayList(),
    val price:String = "",
    val rating:String = "",
    val description:String = "",
    val people:String = "",
    val floor:String = "",
    val carpetArea:String = "",
)
