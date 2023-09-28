package com.satwik.spaces.properties.presentation.detail_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
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
import com.satwik.spaces.core.navigation.Screen
import com.satwik.spaces.properties.presentation.detail_screen.components.FeatureSection
import com.satwik.spaces.properties.presentation.detail_screen.components.ImageSlider
import com.satwik.spaces.properties.presentation.detail_screen.components.PropertyInfoSection
import com.satwik.spaces.properties.presentation.theme.Black
import com.satwik.spaces.properties.presentation.theme.Montserrat
import com.satwik.spaces.properties.presentation.theme.Purple
import com.satwik.spaces.properties.presentation.theme.White


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
            .padding(start = 8.dp, end = 8.dp)
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
                modifier = Modifier.matchParentSize()
            ){

                ImageSlider(listOfUrl = state.property.imageUrls)

                Spacer(modifier = Modifier.height(30.dp))

                PropertyInfoSection(propertyName =  state.property.name, propertyAddress = state.property.address,rating = state.property.rating)

                Spacer(modifier = Modifier.height(30.dp))

                FeatureSection(floor = state.property.floor, people = state.property.people ,sqft = state.property.carpetArea)

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = "Description",
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.Normal,
                    color = White,
                    fontSize = 20.sp,
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "This is description, the property poster is supposed to write something here and fill this nigga up",
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.Normal,
                    color = White,
                    fontSize = 15.sp,
                )

                Spacer(modifier = Modifier.height(30.dp))

                Button(
                    onClick = { navController.navigate(Screen.Confirmation.route) },
                    modifier= Modifier,
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Purple)
                ) {
                    Text(
                        text = "Book now",
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.Normal,
                        color = White,
                        fontSize = 18.sp,
                    )
                }
            }
        }
    }
}



@Preview
@Composable
fun DetailScreenPreview(){
    DetailScreen(navController = rememberNavController())
}