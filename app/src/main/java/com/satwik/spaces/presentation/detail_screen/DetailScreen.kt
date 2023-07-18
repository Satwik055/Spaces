package com.satwik.spaces.presentation.detail_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.satwik.spaces.R
import com.satwik.spaces.presentation.detail_screen.components.FeatureSection
import com.satwik.spaces.presentation.detail_screen.components.PropertyInfoSection
import com.satwik.spaces.presentation.theme.Black
import com.satwik.spaces.presentation.theme.Montserrat
import com.satwik.spaces.presentation.theme.Purple
import com.satwik.spaces.presentation.theme.White

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailScreen(){
    val images = listOf(
        "https://officeinteriordesign.com/wp-content/uploads/2022/08/Your-smartest-investment-1.jpg",
        "https://officedesigner.com/wp-content/uploads/2023/03/office-designer-london.jpeg",
        "https://penkethgroup.com/wp-content/uploads/2022/10/1-29.jpg"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Black)
            .padding(start = 8.dp, end = 8.dp)
    ) {

        ImageSlider(listOfUrl = images)

        Spacer(modifier = Modifier.height(30.dp))

        PropertyInfoSection(propertyName = "Binari Greenwich", propertyAddress = "232 Maple Street, New York", rating = "5.0")

        Spacer(modifier = Modifier.height(30.dp))

        FeatureSection(floor = "25th", people="5" ,sqft = "250")

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
    DetailScreen()
}