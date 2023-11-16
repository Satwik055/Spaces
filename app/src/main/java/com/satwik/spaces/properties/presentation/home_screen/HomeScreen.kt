
package com.satwik.spaces.properties.presentation.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.satwik.spaces.core.components.AnimatedShimmerCard
import com.satwik.spaces.core.navigation.Screen
import com.satwik.spaces.core.theme.Black
import com.satwik.spaces.core.theme.Grey
import com.satwik.spaces.core.theme.White
import com.satwik.spaces.properties.presentation.home_screen.components.TopAppBar
import com.satwik.spaces.properties.presentation.home_screen.tabs.MeetingroomTabScreen


@Composable
fun HomeScreen(
    navController:NavController,
){
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
            .padding(start = 16.dp, end = 16.dp)
    ){

        Column  (
            modifier = Modifier.matchParentSize()
        ){
            Spacer(modifier = Modifier.height(10.dp))

            TopAppBar(
                currentCity = "Lower Manhattan",
                currentState = "New York",
                searchOnClick = {navController.navigate(Screen.Search.route)},
                locationOnClick = {navController.navigate(Screen.Location.route)}
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Explore a suitable workplace for you",
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(modifier = Modifier.height(20.dp))

            val tabItems = listOf("Meeting room", "Workspace", "Coffeeshop", "Lounge")
            var selectedTabIndex by remember { mutableStateOf(0) }
            ScrollableTabRow(
                selectedTabIndex = selectedTabIndex,
                edgePadding = 0.dp,
                containerColor = Color.Transparent,
                divider = { null }
            ) {
                tabItems.forEachIndexed{ index, item ->
                    Tab(
                        selected = index == selectedTabIndex,
                        onClick = { selectedTabIndex = index },
                        text = {
                            Text(
                                text = item,
                                fontSize = 16.sp,
                                color = if(index==selectedTabIndex){White}
                                else { Grey },
                                style = MaterialTheme.typography.titleMedium)
                        }
                    )
                }
            }

            Box{
                when(selectedTabIndex){
                    0 -> MeetingroomTabScreen(navController = rememberNavController())
                }
            }
        }
    }
}

@Composable
fun TestScreen(){
    Box(modifier = Modifier
        .background(color = Color.Red)
        .fillMaxSize())
}


@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(navController = rememberNavController())
}