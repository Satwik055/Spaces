package com.satwik.spaces.properties.presentation.location_screen

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.satwik.spaces.R
import com.satwik.spaces.core.components.DateFeild
import com.satwik.spaces.core.components.SpacesButton
import com.satwik.spaces.core.components.SpacesIconButton
import com.satwik.spaces.core.components.SpacesTextField
import com.satwik.spaces.core.theme.Black
import com.satwik.spaces.core.theme.White
import com.satwik.spaces.properties.presentation.detail_screen.components.PeopleSection
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationScreen(
    navController: NavController,
){

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
                    painter = painterResource(id = R.drawable.ic_caretleft),
                    contentDescription = null,
                    tint = White,
                    modifier = Modifier.offset(x = (-10).dp)

                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Location",
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(modifier = Modifier.height(20.dp))

            var location by remember { mutableStateOf("") }
            SpacesTextField(
                text = location,
                onValueChange ={location=it},
                placeholder = "Search places",
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Dates",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 5.dp)
            )

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

            Spacer(modifier = Modifier.height(60.dp))
            SpacesButton(
                text = "Search"
            ) { TODO() }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun MyPreview() {
    LocationScreen(navController = rememberNavController())
}