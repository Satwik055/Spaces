package com.satwik.spaces.core.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.satwik.spaces.R
import com.satwik.spaces.authentication.domain.model.User
import com.satwik.spaces.bookings.presentation.bookings_screen.BookingsScreen
import com.satwik.spaces.core.ui.nav_drawer.DrawerHeader
import com.satwik.spaces.core.ui.nav_drawer.DrawerItem
import com.satwik.spaces.core.ui.nav_drawer.DrawerItemData
import com.satwik.spaces.core.ui.theme.Black
import com.satwik.spaces.properties.presentation.home_screen.HomeScreen
import com.satwik.spaces.properties.presentation.home_screen.components.TopAppBar
import kotlinx.coroutines.launch


@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun MainScreen(
    navController: NavController,
){

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val user= User(name = "Jeniffer Hindon", email = "jenifferhindon123@gmail.com", profilePicture = "https://i.pinimg.com/474x/a8/8a/bf/a88abf8a61deedc8a415301a1d8f7ca9.jpg")

    val drawerItems = listOf(
        DrawerItemData( label = "Explore", icon = R.drawable.ic_creditcard),
        DrawerItemData(label = "Booking", icon = R.drawable.ic_wallet)
    )

    var selectedDrawerIndex by remember { mutableIntStateOf(0) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet (
                drawerContainerColor = Color(0xFF101010),
            ){
                DrawerHeader(user)
                Divider()
                Spacer(Modifier.height(50.dp))
                drawerItems.forEachIndexed{index, item ->
                    DrawerItem(
                        label = item.label,
                        icon = item.icon,
                        selected = if(selectedDrawerIndex==index){true} else(false),
                        onClick = { selectedDrawerIndex = index }
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
                    searchOnClick = { /*TODO*/ },
                    navDrawerOnClick = { scope.launch { drawerState.apply { if (isClosed) open() else close() } } },
                    locationOnClick = { /*TODO*/ },
                    modifier = Modifier
                        .background(color = Black)
                        .padding(10.dp)
                )
            },
            content = {
                Box(
                    modifier = Modifier.padding(top = it.calculateTopPadding())){
                    when(selectedDrawerIndex){
                        0-> HomeScreen(navController = navController)
                        1-> BookingsScreen(navController = navController)
                    }
                }
            }
        )
    }
}