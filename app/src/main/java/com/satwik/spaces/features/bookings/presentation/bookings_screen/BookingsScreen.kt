package com.satwik.spaces.features.bookings.presentation.bookings_screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.satwik.spaces.data.booking.domain.model.BookedProperty
import com.satwik.spaces.features.bookings.presentation.bookings_screen.components.BookingListItem
import com.satwik.spaces.core.ui.theme.Black

@Composable
fun BookingsScreen(
    navController: NavController,
    viewModel: BookingScreenViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Box(
        Modifier
            .background(color = Black)
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        if(state.error?.isNotEmpty() == true){
            Log.d("@@@Error", state.error )
            Text(
                text = state.error,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        if(state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
        state.bookedProperty?.let {
            BookingList(
                bookedProperties = state.bookedProperty,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
fun BookingList(
    bookedProperties:List<BookedProperty>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
    ){
        items(bookedProperties){
            BookingListItem(
                modifier = Modifier.fillMaxWidth(),
                propertyName = it.property.name,
                propertyAddress = it.property.address,
                thumbnailURL = it.property.imageUrls.first(),
                checkinDate = it.checkInDate.toString(),
                checkoutDate = it.checkOutDate,
                onClick = {/*TODO*/}
            )
        }
    }
}


