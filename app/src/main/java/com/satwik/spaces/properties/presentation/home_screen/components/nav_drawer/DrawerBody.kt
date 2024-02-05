package com.satwik.spaces.properties.presentation.home_screen.components.nav_drawer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DrawerBody(
    items:List<MenuItem>,
    modifier: Modifier = Modifier,
    onItemClick:(MenuItem) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ){
        items(items){item->
            NavDrawerMenuItem(title = item.title, onClick = { onItemClick(item) })
        }
    }
}