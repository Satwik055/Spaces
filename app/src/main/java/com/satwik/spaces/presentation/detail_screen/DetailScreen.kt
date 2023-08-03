package com.satwik.spaces.presentation.detail_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.satwik.spaces.common.DummyApi
import com.satwik.spaces.data.repository.PropertiesRepositoryImpl
import com.satwik.spaces.domain.repository.PropertiesRepository
import com.satwik.spaces.presentation.detail_screen.components.FeatureSection
import com.satwik.spaces.presentation.detail_screen.components.ImageSlider
import com.satwik.spaces.presentation.detail_screen.components.PropertyInfoSection
import com.satwik.spaces.presentation.theme.Black
import com.satwik.spaces.presentation.theme.Montserrat
import com.satwik.spaces.presentation.theme.Purple
import com.satwik.spaces.presentation.theme.White
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.annotation.Nonnull
import com.satwik.spaces.domain.use_case.getProperties.GetProperties as GetProperties1


@Composable
fun DetailScreen(navController:NavController, propertyId:Int){

    val property = DummyApi.getPropertyById(propertyId)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Black)
            .padding(start = 8.dp, end = 8.dp)
    ) {


        ImageSlider(listOfUrl = property!!.imageUrls)

        Spacer(modifier = Modifier.height(30.dp))

        PropertyInfoSection(propertyName = property.name, propertyAddress = property.address,rating = property.rating)

        Spacer(modifier = Modifier.height(30.dp))

        FeatureSection(floor = property.floor, people = property.people ,sqft = property.carpetArea)

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
            onClick = { /*TODO*/ },
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



@Preview
@Composable
fun DetailScreenPreview(){
    DetailScreen(navController = rememberNavController(), propertyId = 1)
}