package com.satwik.spaces.main_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.satwik.booking.presentation.BookingsScreen
import com.satwik.designsystem.components.nav_drawer.DrawerHeader
import com.satwik.designsystem.components.nav_drawer.DrawerItem
import com.satwik.designsystem.components.nav_drawer.DrawerItemData
import com.satwik.designsystem.theme.Black
import com.satwik.explore.explore.presentation.explore_screen.ExploreScreen
import com.satwik.explore.explore.presentation.explore_screen.components.TopAppBar
import com.satwik.spaces.R
import com.satwik.spaces.navigation.model.Graph
import com.satwik.spaces.navigation.model.Screen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun MainScreen(
    navController: NavController,
    viewModel: MainScreenViewModel = hiltViewModel(),
){

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val currentUser = viewModel.user.value

    val drawerItems = listOf(
        DrawerItemData(label = "Explore", icon = R.drawable.ic_map),
        DrawerItemData(label = "My Booking", icon = R.drawable.ic_calendar)
    )

    var selectedDrawerIndex by remember { mutableIntStateOf(0) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet (
                modifier= Modifier.width(310.dp),
                drawerContainerColor = Color(0xFF101010)
            ){
                DrawerHeader(currentUser)
                drawerItems.forEachIndexed{index, item ->
                    DrawerItem(
                        label = item.label,
                        icon = item.icon,
                        selected = if(selectedDrawerIndex==index){true} else(false),
                        onClick = {
                            selectedDrawerIndex = index
                            scope.launch {
                                delay(300)
                                drawerState.close()
                            }
                        }
                    )
                }
                Spacer(modifier = Modifier.weight(1f))


                HorizontalDivider( modifier = Modifier.padding(horizontal = 16.dp))
                TextButton(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(5.dp),
                    onClick = {
                        viewModel.logout()
                        navController.popBackStack()
                        navController.navigate(Graph.Auth.route) {
                            popUpTo(Screen.Main.route) { inclusive = true }
                        }
                    },

                    ) {
                    Text(
                        text = "Logout",
                        color = Color.Red,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        },
    ) {
        Scaffold (
            topBar = {
                TopAppBar(
                    currentCity ="Lower Manhattan",
                    currentState ="New York",
                    searchOnClick = { navController.navigate(Screen.Search.route) },
                    navDrawerOnClick = { scope.launch { drawerState.apply { if (isClosed) open() else close() } } },
                    locationOnClick = { navController.navigate(Screen.Location.route) },
                    modifier = Modifier
                        .background(color = Black)
                        .padding(10.dp)
                )
            },
            content = {
                Box(
                    modifier = Modifier.padding(top = it.calculateTopPadding())){
                    when(selectedDrawerIndex){
                        0-> ExploreScreen(navController = navController)
                        1-> BookingsScreen(navController = navController)
                    }
                }
            }
        )
    }
}
