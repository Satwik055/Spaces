package com.satwik.spaces.features.location.presentation.address_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.satwik.spaces.core.ui.components.SpacesButton
import com.satwik.spaces.core.ui.theme.Black
import com.satwik.spaces.features.location.presentation.location_screen.LocationScreenViewModel
import com.satwik.spaces.features.search.presentation.components.SearchBar

@Composable
fun AddressScreen(
    navController: NavController,
    viewModel: LocationScreenViewModel = hiltViewModel(),
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
            .padding(start = 16.dp, end = 16.dp)
    ){
        var searchText by remember { mutableStateOf("") }
        SearchBar(
            query = searchText,
            onQueryChange = {searchText=it},
            placeholder = "Search places" ,
            leadingButtonOnClick = { navController.popBackStack() },
            trailButtonOnClick = { searchText = "" },
            autoFocus = true,
            modifier = Modifier.align(Alignment.TopCenter)
        )

        SpacesButton(
            text = "Confirm",
            modifier = Modifier.align(Alignment.BottomCenter),
            onClick = {
                viewModel.saveLocation(searchText)
                navController.popBackStack()
            }
        )
    }
}