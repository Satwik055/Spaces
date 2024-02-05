
package com.satwik.spaces.properties.presentation.home_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Thin
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.satwik.spaces.core.components.ButtonType
import com.satwik.spaces.core.components.SpacesButton
import com.satwik.spaces.core.navigation.Screen
import com.satwik.spaces.core.theme.Grey
import com.satwik.spaces.core.theme.White
import com.satwik.spaces.properties.presentation.home_screen.components.TopAppBar
import com.satwik.spaces.properties.presentation.home_screen.tabs.screens.CoffeeshopTabScreen
import com.satwik.spaces.properties.presentation.home_screen.tabs.screens.LoungeTabScreen
import com.satwik.spaces.properties.presentation.home_screen.tabs.screens.MeetingroomTabScreen
import com.satwik.spaces.properties.presentation.home_screen.tabs.screens.WorkspaceTabScreen
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController:NavController,
){

    Box(
        modifier = Modifier
            .fillMaxSize()
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
                    locationOnClick = { navController.navigate(Screen.Location.route) },
                    navDrawerOnClick = { /*TODO*/ }
                )

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = "Explore a suitable workplace for you",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.W200
                )

                Spacer(modifier = Modifier
                    .height(20.dp)
                )

                val tabItems = listOf("Meeting room", "Workspace", "Coffeeshop", "Lounge")
                var selectedTabIndex by remember { mutableIntStateOf(0) }

                ScrollableTabRow(
                    selectedTabIndex = selectedTabIndex,
                    edgePadding = 0.dp,
                    contentColor = Color.Transparent,
                    containerColor = Color.Transparent,
                    divider = { Divider(thickness = Dp.Hairline) },

                ) {
                    tabItems.forEachIndexed{ index, item ->
                        Tab(
                            modifier=Modifier.height(35.dp),
                            selected = index == selectedTabIndex,
                            onClick = { selectedTabIndex = index },
                            text = {
                                Text(
                                    text = item,
                                    fontSize = 15 .sp,
                                    fontWeight = FontWeight.W300,
                                    color = if(index==selectedTabIndex){White}
                                    else {Grey},
                                    style = MaterialTheme.typography.titleMedium
                                )
                            }
                        )
                    }
                }


                Box{
                    when(selectedTabIndex){
                        0 -> MeetingroomTabScreen(navController = navController)
                        1 -> WorkspaceTabScreen(navController = navController)
                        2 -> CoffeeshopTabScreen(navController = navController)
                        3 -> LoungeTabScreen(navController = navController)
                    }
                }
            }
        }

}



@Preview
@Composable
fun HomeScreenPreview(){
}

