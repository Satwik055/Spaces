package com.satwik.spaces.properties.presentation.detail_screen

import android.annotation.SuppressLint
import android.os.Build
import android.widget.ScrollView
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.satwik.spaces.R
import com.satwik.spaces.core.components.AmenitiesChip
import com.satwik.spaces.core.components.DateFeild
import com.satwik.spaces.core.components.InfoCard
import com.satwik.spaces.core.components.SpacesButton
import com.satwik.spaces.core.navigation.Screen
import com.satwik.spaces.properties.presentation.detail_screen.components.FeatureSection
import com.satwik.spaces.properties.presentation.detail_screen.components.ImageSlider
import com.satwik.spaces.properties.presentation.detail_screen.components.PropertyInfoSection
import com.satwik.spaces.core.theme.Black
import com.satwik.spaces.core.theme.DarkGrey
import com.satwik.spaces.core.theme.Grey
import com.satwik.spaces.core.theme.Montserrat
import com.satwik.spaces.core.theme.Purple
import com.satwik.spaces.core.theme.White
import com.satwik.spaces.properties.presentation.detail_screen.components.PeopleSection
import java.nio.file.WatchEvent
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
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

                Spacer(modifier = Modifier.height(40.dp))

                Text(
                    text = "Booking Date",
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.Normal,
                    color = White,
                    fontSize = 18.sp,
                )

                Spacer(modifier = Modifier.height(20.dp))

                //----------------------------Date Section----------------------------------//

                Row {
                    //From Date
                    val calenderState1 = rememberUseCaseState()
                    var selectedDate1 by remember { mutableStateOf(LocalDate.now()) }
                    val formattedDate1 by remember { derivedStateOf { DateTimeFormatter.ofPattern("dd MMM yyy").format(selectedDate1) } }

                    CalendarDialog(
                        state = calenderState1,
                        selection = CalendarSelection.Date{ selectedDate1 = it}
                    )
                    DateFeild(
                        text = formattedDate1,
                        onClick = { calenderState1.show() }
                    )

                    //To Date
                    val calenderState2 = rememberUseCaseState()
                    var selectedDate2 by remember { mutableStateOf(LocalDate.now().plusDays(2)) }
                    val formattedDate2 by remember { derivedStateOf { DateTimeFormatter.ofPattern("dd MMM yyy").format(selectedDate2) } }

                    CalendarDialog(
                        state = calenderState2,
                        selection = CalendarSelection.Date{ selectedDate2 = it}
                    )
                    Spacer(modifier = Modifier.width(14.dp))

                    DateFeild(
                        text = formattedDate2,
                        onClick = { calenderState2.show() }
                    )

                }

                //----------------------------------------------------------------------//

                Spacer(modifier = Modifier.height(30.dp))

                PeopleSection()

                Spacer(modifier = Modifier.height(30.dp))

                InfoCard(
                    title = "Cancellation Policy",
                    content ="Cancel 24hrs before check in to get full refund and cancellation before 12hrs check in will get partial refund"
                )

                Spacer(modifier = Modifier.height(30.dp))


                Box (
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    Text(
                        text = "3400$/Day",
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.Normal,
                        color = White,
                        fontSize = 17.sp,
                        modifier = Modifier.align(Alignment.CenterStart)
                    )

                    SpacesButton(
                        text = "Book Now",
                        onClick = { TODO() },
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .width(188.dp)
                            .align(Alignment.CenterEnd)
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