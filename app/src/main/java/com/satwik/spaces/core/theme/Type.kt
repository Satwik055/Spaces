package com.satwik.spaces.core.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.satwik.spaces.R

val Montserrat = FontFamily(
    Font(R.font.montserrat_light, FontWeight.Light),
    Font(R.font.montserrat_regular, FontWeight.Normal),
    Font(R.font.montserrat_medium, FontWeight.Medium),
    Font(R.font.montserrat_semibold, FontWeight.SemiBold),
    Font(R.font.montserrat_bold, FontWeight.Bold),
    Font(R.font.montserrat_thin, FontWeight.Thin)
)

val Typography = Typography(

    headlineLarge = TextStyle(
        lineHeight = 35.sp,
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        color = White,
        fontSize = 34.sp,
    ),

    headlineMedium = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        color = White,
        fontSize = 26.sp,
    ),

    headlineSmall = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        color = White,
        fontSize = 20.sp,
    ),

    titleMedium = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        color = White,
        fontSize = 16.sp,
    ),

    labelLarge = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        color = White,
        fontSize = 18.sp,
    ) ,


    labelSmall = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
        color = White,
        fontSize = 13.sp,
    ),




)

