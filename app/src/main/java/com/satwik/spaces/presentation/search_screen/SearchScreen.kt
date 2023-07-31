package com.satwik.spaces.presentation.search_screen

import android.widget.EditText
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.satwik.spaces.presentation.search_screen.components.SearchBar
import com.satwik.spaces.presentation.theme.Black


@Composable
fun SearchScreen(navController:NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Black)
            .padding(start = 8.dp, end = 8.dp)

    ) {
        var text by remember { mutableStateOf("") }
        SearchBar(
            query = text,
            onQueryChange = {text = it},
            placeholder = "Search for workspaces",
            backButtonOnClick = { /*TODO*/ },
            cancelButtonOnClick = { /*TODO*/ })

    }
}