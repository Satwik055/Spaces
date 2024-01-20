package com.satwik.spaces.properties.presentation.home_screen.tabs.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.satwik.spaces.core.components.ListingCard
import com.satwik.spaces.core.navigation.Screen
import com.satwik.spaces.properties.domain.model.Property

@Composable
fun PopularSection(properties:List<Property>, navController: NavController) {

    Spacer(modifier = Modifier.height(30.dp))

    Text(
        text = "Popular",
        style = MaterialTheme.typography.titleMedium,
    )

    Spacer(modifier = Modifier.height(10.dp))

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(properties){
            ListingCard(
                propertyName = it.name,
                propertyAddress = it.address,
                titleFontSize = 17.sp,
                addressFontSize = 10.sp,
                imageUrl = it.imageUrls.first(),
                onClick = { navController.navigate(Screen.Detail.passId(it.id))}
            )
        }
    }
    Spacer(modifier = Modifier.height(40.dp))

    Text(
        text = "Near You",
        style = MaterialTheme.typography.titleMedium
    )

    Spacer(modifier = Modifier.height(10.dp))

}