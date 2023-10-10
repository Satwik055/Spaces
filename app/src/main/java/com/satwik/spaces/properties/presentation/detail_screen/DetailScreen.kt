package com.satwik.spaces.properties.presentation.detail_screen

import android.annotation.SuppressLint
import android.widget.ScrollView
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.satwik.spaces.R
import com.satwik.spaces.core.components.AmenitiesChip
import com.satwik.spaces.core.components.SpacesButton
import com.satwik.spaces.core.navigation.Screen
import com.satwik.spaces.properties.presentation.detail_screen.components.FeatureSection
import com.satwik.spaces.properties.presentation.detail_screen.components.ImageSlider
import com.satwik.spaces.properties.presentation.detail_screen.components.PropertyInfoSection
import com.satwik.spaces.core.theme.Black
import com.satwik.spaces.core.theme.Montserrat
import com.satwik.spaces.core.theme.Purple
import com.satwik.spaces.core.theme.White


@Composable
fun DetailScreen(
    navController: NavController,
    viewModel: DetailScreenViewModel = hiltViewModel()
){
    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Black)
            .padding(start = 16.dp, end = 16.dp)

    ) {

        if(state.isLoading){
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Purple
            )
        }

        if(state.error?.isNotBlank() == true) {
            Text(
                text = state.error.toString(),
                fontFamily = Montserrat,
                fontWeight = FontWeight.Normal,
                color = White,
                fontSize = 20.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }


        state.property?.let {


            Column(
                modifier = Modifier
                    .matchParentSize()
                    .verticalScroll(rememberScrollState())
            ){

                ImageSlider(listOfUrl = state.property.imageUrls)

                Spacer(modifier = Modifier.height(30.dp))

                PropertyInfoSection(propertyName =  state.property.name, propertyAddress = state.property.address,rating = state.property.rating)

                Spacer(modifier = Modifier.height(30.dp))

                Row (
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    AmenitiesChip(name = "8th Floor", icon = R.drawable.ic_building)
                    AmenitiesChip(name = "250 sqft", icon = R.drawable.ic_area)
                    AmenitiesChip(name = "4 People", icon = R.drawable.ic_people)
                }
                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = "Description",
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.Normal,
                    color = White,
                    fontSize = 18.sp,
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "This is description, the property poster is supposed to write something here and fill this nigga upThis is description, the property poster is supposed to write something here and fill this nigga upThis is description, the property poster is supposed to write something here and fill this nigga upThis is description, the property poster is supposed to write something here and fill this nigga up  ",
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.Normal,
                    color = White,
                    fontSize = 14.sp,

                )

                Spacer(modifier = Modifier.height(30.dp))

                SpacesButton(
                    text = "Book Now",
                    onClick = { TODO() },
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .fillMaxWidth()
                )

            }
        }
    }
}



@Preview
@Composable
fun DetailScreenPreview(){
    DetailScreen(navController = rememberNavController())

}