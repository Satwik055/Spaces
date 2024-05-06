package com.satwik.detail.presentation.detail_screen

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
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
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
import androidx.navigation.NavController
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.satwik.common.Graph
import com.satwik.designsystem.components.AmenitiesChip
import com.satwik.designsystem.components.DateFeild
import com.satwik.designsystem.components.ImageSlider
import com.satwik.designsystem.components.InfoCard
import com.satwik.designsystem.theme.Purple
import com.satwik.designsystem.theme.White
import com.satwik.designsystem.theme.poppins
import com.satwik.detail.presentation.detail_screen.components.BottomBarSection
import com.satwik.detail.presentation.detail_screen.components.PropertyInfoSection
import com.satwik.property.domain.model.Property
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun DetailScreen(
    state: State<DetailScreenUiState>,
    navController: NavController,
){
    val propertyState = state.value.propertyState
    val checkinDate = state.value.checkinDate
    val checkoutDate = state.value.checkoutDate

    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {

        when {
            propertyState.isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = Purple
                )
            }

            propertyState.error.isNotBlank() ->
                Text(
                    text = propertyState.error,
                    style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
                    fontFamily = poppins,
                    fontWeight = FontWeight.Normal,
                    color = White,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center)
                )

            else->
                propertyState.property?.let {
                    Content(
                        property = propertyState.property,
                        checkinDate = checkinDate,
                        checkoutDate =  checkoutDate,
                        navController = navController
                    )
                }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun Content(
    property: Property,
    checkinDate:String,
    checkoutDate:String,
    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .matchParentSize()
                .verticalScroll(rememberScrollState())
                .padding(start = 16.dp, end = 16.dp)

        ){

            ImageSlider(listOfUrl = property.imageUrls)

            Spacer(modifier = Modifier.height(30.dp))

            PropertyInfoSection(propertyName =  property.name, propertyAddress = property.address,rating = property.rating)

            Spacer(modifier = Modifier.height(30.dp))

            Row (
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
                AmenitiesChip(name = "${property.floor} Floor", icon = com.satwik.designsystem.R.drawable.ic_building)
                AmenitiesChip(name = "${property.carpetArea} sqft", icon = com.satwik.designsystem.R.drawable.ic_area)
                AmenitiesChip(name = "${property.people} People", icon = com.satwik.designsystem.R.drawable.ic_people)
            }
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = checkinDate,
                style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
                fontFamily = poppins,
                fontWeight = FontWeight.Normal,
                color = White,
                fontSize = 18.sp,
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = property.description,
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
                    text = checkinDate,
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
                    text = checkoutDate,
                    onClick = { calenderState2.show() }
                )
            }

            //----------------------------------------------------------------------//

            Spacer(modifier = Modifier.height(30.dp))

            Spacer(modifier = Modifier.height(30.dp))

            InfoCard(
                title = "Cancellation Policy",
                content = "Cancel 24hrs before check in to get full refund and cancellation before 12hrs check in will get partial refund"
            )

            Spacer(modifier = Modifier.height(100.dp))

        }

        BottomBarSection(
            price = property.price + "$/Day",
            modifier = Modifier.align(Alignment.BottomCenter),
            onClick = { navController.navigate(Graph.Checkout.passId(property.id)) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview(){

}

