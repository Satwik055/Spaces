package com.satwik.spaces.search.presentation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.satwik.spaces.core.navigation.Screen
import com.satwik.spaces.search.presentation.components.SearchBar
import com.satwik.spaces.core.theme.Black
import com.satwik.spaces.core.theme.Montserrat
import com.satwik.spaces.core.theme.Purple
import com.satwik.spaces.core.theme.White
import com.satwik.spaces.core.components.ListingCard
import com.satwik.spaces.properties.presentation.home_screen.tabs.TabScreenViewModel

@Composable
fun SearchScreen(
    navController:NavController,
    viewModel: SearchScreenViewModel = hiltViewModel()

){
    LaunchedEffect(Unit){
        viewModel.searchProperty("The Edge")
    }

    val state = viewModel.state.value

    Log.d("@@@", "${ state.isLoading }")
    Log.d("@@@", "${ state.error }")
    Log.d("@@@", "${ state.searchResult }")


    Column {
        var text by remember { mutableStateOf("") }
        SearchBar(
            query = text,
            onQueryChange = {text = it},
            placeholder = "Search for workspaces",
            leadingButtonOnClick = { navController.popBackStack() },
            trailButtonOnClick = { text = "" },
            autoFocus = true
        )

        Box (
            modifier = Modifier
                .fillMaxSize()
                .background(Black)
                .padding(start = 8.dp, end = 8.dp)
        ){
            if(state.isLoading){
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = Purple
                )
            }

            if(state.error?.isNotBlank() == true) {
                Text(
                    text = state.error,
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.Normal,
                    color = White,
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            state.searchResult?.let {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Black)
                        .padding(start = 8.dp, end = 8.dp)

                ) {

                    Spacer(modifier = Modifier.height(30.dp))

                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ){items(state.searchResult){
                        ListingCard(
                            propertyName = it.name,
                            propertyAddress = it.address,
                            imageUrl = it.imageUrls.first(),
                            onClick = { navController.navigate(Screen.Detail.passId(it.id))},
                            modifier = Modifier
                                .height(204.dp)
                                .fillMaxWidth()
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun SearchScreenPreview(){
}