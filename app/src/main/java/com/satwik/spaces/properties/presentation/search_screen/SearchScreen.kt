package com.satwik.spaces.properties.presentation.search_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.satwik.spaces.core.components.AnimatedShimmer
import com.satwik.spaces.properties.presentation.search_screen.components.SearchBar
import com.satwik.spaces.core.theme.Black


@Composable
fun SearchScreen(navController:NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Black)
            .padding(start = 8.dp, end = 8.dp)

    ) {
        AnimatedShimmer()
        var text by remember { mutableStateOf("") }
        SearchBar(
            query = text,
            onQueryChange = {text = it},
            placeholder = "Search for workspaces",
            leadingButtonOnClick = { navController.popBackStack() },
            trailButtonOnClick = { text = "" },
            autoFocus = true
        )

    }
}