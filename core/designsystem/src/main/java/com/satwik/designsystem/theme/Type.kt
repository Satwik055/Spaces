package com.satwik.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.satwik.designsystem.R

val poppins = FontFamily(
    Font(R.font.poppins_extra_light, FontWeight.ExtraLight),
    Font(R.font.poppins_light, FontWeight.Light),
    Font(R.font.poppins_thin, FontWeight.Thin),
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium,FontWeight.Medium)
    )

val fontFamily = poppins

val Typography = Typography(
    headlineLarge = TextStyle(
        lineHeight = 35.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        color = White,
        fontSize = 34.sp,
    ),

    headlineMedium = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        color = White,
        fontSize = 26.sp,
    ),

    headlineSmall = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        color = White,
        fontSize = 20.sp,
    ),

    titleMedium = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        color = White,
        fontSize = 16.sp,
    ),

    labelLarge = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        color = White,
        fontSize = 18.sp,
    ) ,


    labelSmall = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        color = White,
        fontSize = 14.sp,
    ),
)

