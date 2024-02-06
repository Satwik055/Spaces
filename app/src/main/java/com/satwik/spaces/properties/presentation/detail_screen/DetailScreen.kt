package com.satwik.spaces.properties.presentation.detail_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.satwik.spaces.R
import com.satwik.spaces.core.ui.components.AmenitiesChip
import com.satwik.spaces.core.ui.components.DateFeild
import com.satwik.spaces.core.ui.components.InfoCard
import com.satwik.spaces.core.navigation.objects.Screen
import com.satwik.spaces.core.ui.theme.Purple
import com.satwik.spaces.core.ui.theme.White
import com.satwik.spaces.core.ui.theme.poppins
import com.satwik.spaces.properties.presentation.detail_screen.components.BottomBarSection
import com.satwik.spaces.properties.presentation.detail_screen.components.ImageSlider
import com.satwik.spaces.properties.presentation.detail_screen.components.PropertyInfoSection
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

    val checkinDate = viewModel.getCheckinDate().collectAsState(initial = "")
    val checkoutDate = viewModel.getCheckoutDate().collectAsState(initial = "")


    Box(
        modifier = Modifier
            .fillMaxSize()

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
                style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
                fontFamily = poppins,
                fontWeight = FontWeight.Normal,
                color = White,
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        state.property?.let {
            Box(
                modifier = Modifier.fillMaxSize()
            ){
                Column(
                    modifier = Modifier
                        .matchParentSize()
                        .verticalScroll(rememberScrollState())
                        .padding(start = 16.dp, end = 16.dp)

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
                        text = checkinDate.value,
                        style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
                        fontFamily = poppins,
                        fontWeight = FontWeight.Normal,
                        color = White,
                        fontSize = 18.sp,
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = state.property.description,
                        style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
                        fontFamily = poppins,
                        lineHeight= 23.sp,
                        fontWeight = FontWeight.Light,
                        color = White,
                        fontSize = 14.sp,
                    )

                    Spacer(modifier = Modifier.height(40.dp))

                    Text(
                        text = "Booking Date",
                        fontFamily = poppins,
                        fontWeight = FontWeight.Normal,
                        color = White,
                        fontSize = 18.sp,
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    //----------------------------Date Section----------------------------------//

                    Row {
                        //Checkin Date
                        val calenderState1 = rememberUseCaseState()
                        var selectedDate1 by remember { mutableStateOf(LocalDate.now()) }
                        val formattedDate1 by remember { derivedStateOf { DateTimeFormatter.ofPattern("dd MMM yyy").format(selectedDate1) } }

                        CalendarDialog(
                            state = calenderState1,
                            selection = CalendarSelection.Date{ selectedDate1 = it}
                        )
                        DateFeild(
                            text = checkinDate.value,
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
                            text = checkoutDate.value,
                            onClick = { calenderState2.show() }
                        )



                    }

                    //----------------------------------------------------------------------//

                    Spacer(modifier = Modifier.height(30.dp))

                    val peeps by remember { mutableIntStateOf(1) }
//                    Counter(viewModel = viewModel)

                    Spacer(modifier = Modifier.height(30.dp))

                    InfoCard(
                        title = "Cancellation Policy",
                        content = "Cancel 24hrs before check in to get full refund and cancellation before 12hrs check in will get partial refund"
                    )

                    Spacer(modifier = Modifier.height(100.dp))

                }
            }
            BottomBarSection(
                price = state.property.price + "$/Day",
                modifier = Modifier.align(Alignment.BottomCenter),
                onClick = { navController.navigate(Screen.Checkout.route) }
            )
        }
    }
}



@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DetailScreenPreview(){

}

