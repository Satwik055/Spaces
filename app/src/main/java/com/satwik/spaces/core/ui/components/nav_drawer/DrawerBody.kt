package com.satwik.spaces.core.ui.components.nav_drawer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.satwik.spaces.R

@Composable
fun DrawerBody(
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        DrawerItem(label = "Explore", icon = R.drawable.ic_wallet, onClick = { /*TODO*/ }, selected = true)
        DrawerItem(label = "Booking", icon = R.drawable.ic_wallet, onClick = { /*TODO*/ })
        DrawerItem(label = "Settings", icon = R.drawable.ic_wallet, onClick = { /*TODO*/ })
        DrawerItem(label = "Support", icon = R.drawable.ic_wallet, onClick = { /*TODO*/ })
    }
}