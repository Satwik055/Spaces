package com.satwik.spaces.properties.presentation.home_screen

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satwik.spaces.core.components.AnimatedShimmerCard
import com.satwik.spaces.core.components.AnimatedShimmerText
import com.satwik.spaces.core.components.CardSize
import com.satwik.spaces.core.navigation.Screen
import com.satwik.spaces.core.theme.Montserrat
import com.satwik.spaces.core.theme.White
import com.satwik.spaces.properties.presentation.home_screen.components.ListingCard

@Composable
fun ShimmerLoadingLayout() {

    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Spacer(modifier = Modifier.height(30.dp))

        AnimatedShimmerText()

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {
            AnimatedShimmerCard(cardSize = CardSize.SMALL)
            Spacer(modifier = Modifier.width(8.dp))
            AnimatedShimmerCard(cardSize = CardSize.SMALL)
            Spacer(modifier = Modifier.width(8.dp))
            AnimatedShimmerCard(cardSize = CardSize.SMALL)
        }

        Spacer(modifier = Modifier.height(40.dp))

        AnimatedShimmerText()

        Spacer(modifier = Modifier.height(10.dp))

        Column (
            modifier = Modifier.verticalScroll(rememberScrollState())
        ){
            AnimatedShimmerCard(cardSize = CardSize.LARGE)
            Spacer(modifier = Modifier.height(10.dp))
            AnimatedShimmerCard(cardSize = CardSize.LARGE)
            Spacer(modifier = Modifier.height(10.dp))
            AnimatedShimmerCard(cardSize = CardSize.LARGE)
        }
    }
}