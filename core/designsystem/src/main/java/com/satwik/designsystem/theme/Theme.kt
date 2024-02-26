package com.satwik.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable


private val darkColorScheme = darkColorScheme(

    //Button (Container, text)
    primary = Purple,
    onPrimary = White,
)

@Composable
fun SpacesTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = darkColorScheme,
        typography = Typography,
        content = content
    )
}

