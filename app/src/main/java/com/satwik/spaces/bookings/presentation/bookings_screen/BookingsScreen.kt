package com.satwik.spaces.bookings.presentation.bookings_screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
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
import com.satwik.spaces.bookings.domain.model.BookedProperty
import com.satwik.spaces.payments.domain.model.Booking
import com.satwik.spaces.bookings.presentation.bookings_screen.components.BookingListItem
import com.satwik.spaces.properties.domain.model.Property

@Composable
fun BookingsScreen(
    viewModel: BookingScreenViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Box(
        Modifier.fillMaxSize().padding(start = 16.dp, end = 16.dp)
    ) {
        if(state.error?.isNotEmpty() == true){
            Log.d("@@@Error", state.error )
            Text(
                text = state.error,
                style = MaterialTheme.typography.titleMedium
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

