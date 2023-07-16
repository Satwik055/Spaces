package com.satwik.spaces.domain.model

import androidx.annotation.DrawableRes

data class Property(
    val propertyName:String,
    val propertyAddress:String,
    @DrawableRes
    val backgroundImage:Int
)
