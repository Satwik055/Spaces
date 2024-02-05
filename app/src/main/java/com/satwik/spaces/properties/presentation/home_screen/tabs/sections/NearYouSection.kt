package com.satwik.spaces.properties.presentation.home_screen.tabs.sections

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.satwik.spaces.core.components.ListingCard
import com.satwik.spaces.core.navigation.Screen
import com.satwik.spaces.properties.domain.model.Property

fun LazyListScope.NearYouSection(properties:List<Property>, navController: NavController) {


    items(properties){
        ListingCard(
            propertyName = it.name,
            propertyAddress = it.address,
            imageUrl = it.imageUrls.first(),
            onClick = { navController.navigate(Screen.Detail.passId(it.id))},
            modifier = Modifier
                .padding(bottom = 8.dp)
                .height(204.dp)
                .fillMaxWidth()
        )
    }
}