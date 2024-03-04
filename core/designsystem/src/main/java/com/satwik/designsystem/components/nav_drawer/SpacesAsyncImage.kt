package com.satwik.designsystem.components.nav_drawer

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@Composable
fun SpacesAsyncImage(
    imageUrl:String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = imageUrl,
        contentScale = ContentScale.Crop,
        contentDescription = null,
        modifier = modifier
    )
}