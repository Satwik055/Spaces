package com.satwik.location.presentation.location_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.satwik.common.Screen
import com.satwik.designsystem.components.DateFeild
import com.satwik.designsystem.components.SpacesButton
import com.satwik.designsystem.components.SpacesTextField
import com.satwik.designsystem.theme.Black
import com.satwik.designsystem.theme.White
import com.satwik.location.presentation.location_screen.components.Counter
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LocationScreen(
    navController: NavController,
    viewModel: LocationScreenViewModel = hiltViewModel()
){

    val location = viewModel.getLocation().collectAsState(initial = "").value
    val peopleCount = viewModel.getPeople().collectAsState(initial = "").value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Column {

            Spacer(modifier = Modifier.height(14.dp))

            IconButton(onClick = { navController.popBackStack() },
                modifier = Modifier
                    .size(45.dp)
            ) {
                Icon(
                    painter = painterResource(id = com.satwik.designsystem.R.drawable.ic_caretleft),
                    contentDescription = null,
                    tint = White,
                    modifier = Modifier.offset(x = (-10).dp)

                )
            }
            
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Location",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier
            )

            Spacer(modifier = Modifier.height(20.dp))

            SpacesTextField(
                text = location,
                enabled = false,
                onValueChange ={/*TODO*/},
                placeholder = "Search places",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { navController.navigate(Screen.AddressScreen.route) }

            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Dates",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 5.dp)
            )

            //----------------------------Date Section----------------------------------//
            Row {
                //Checkin Date
                val calenderState1 = rememberUseCaseState()
                var checkinDate by remember { mutableStateOf(LocalDate.now()) }
                val formattedCheckinDate by remember { derivedStateOf { DateTimeFormatter.ofPattern("dd MMM yyy").format(checkinDate) } }


                CalendarDialog(
                    state = calenderState1,
                    selection = CalendarSelection.Date{ checkinDate = it}
                )
                DateFeild(
                    text = formattedCheckinDate,
                    onClick = { calenderState1.show() }
                )

                LaunchedEffect(formattedCheckinDate){
                    viewModel.saveCheckinDate(formattedCheckinDate)
                }


                //Checkout Date
                val calenderState2 = rememberUseCaseState()
                var checkoutDate by remember { mutableStateOf(LocalDate.now().plusDays(2)) }
                val formattedCheckoutDate by remember { derivedStateOf { DateTimeFormatter.ofPattern("dd MMM yyy").format(checkoutDate) } }

                CalendarDialog(
                    state = calenderState2,
                    selection = CalendarSelection.Date{ checkoutDate = it}
                )
                Spacer(modifier = Modifier.width(14.dp))

                DateFeild(
                    text = formattedCheckoutDate,
                    onClick = { calenderState2.show() }
                )
                LaunchedEffect(formattedCheckoutDate){
                    viewModel.saveCheckoutDate(formattedCheckoutDate)
                }
            }

            //----------------------------------------------------------------------//

            Spacer(modifier = Modifier.height(30.dp))

            Counter(viewModel = viewModel)

            Spacer(modifier = Modifier.height(60.dp))
            SpacesButton(
                text = "Search",
                onClick = { navController.popBackStack() }
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun MyPreview() {
    LocationScreen(navController = rememberNavController())
}