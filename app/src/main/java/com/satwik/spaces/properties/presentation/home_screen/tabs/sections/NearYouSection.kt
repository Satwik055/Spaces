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
import com.satwik.spaces.properties.presentation.home_screen.tabs.TabScreenViewModel

/**
 * @param viewModel
 * used to save propertyId to datastore,
 * giving that the viewModel should contain a savePropertyId() method
 *
 * @param properties
 * List<Property> which is displayed in the lazy row
 * */
fun LazyListScope.NearYouSection(
    properties:List<Property>,
    navController: NavController,
    viewModel:TabScreenViewModel
) {


    items(properties){
        ListingCard(
            propertyName = it.name,
            propertyAddress = it.address,
            imageUrl = it.imageUrls.first(),
            onClick = {
                viewModel.savePropertyId(it.id)
                navController.navigate(Screen.Detail.route)
                      },
            modifier = Modifier
                .padding(bottom = 8.dp)
                .height(204.dp)
                .fillMaxWidth()
        )
    }
}