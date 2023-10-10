package com.satwik.spaces.properties.presentation.location_screen

import android.icu.util.LocaleData
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
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
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.maxkeppeker.sheets.core.models.base.UseCaseState
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.satwik.spaces.R
import com.satwik.spaces.core.components.DateFeild
import com.satwik.spaces.core.components.SpacesButton
import com.satwik.spaces.core.components.SpacesTextField
import com.satwik.spaces.core.theme.Black
import com.satwik.spaces.core.theme.Montserrat
import com.satwik.spaces.core.theme.White
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LocationScreen(
    navController: NavController
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Column {

            Spacer(modifier = Modifier.height(14.dp))

            IconButton(onClick = { TODO() },
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
                fontFamily = Montserrat,
                fontWeight = FontWeight.Normal,
                color = White,
                fontSize = 34.sp,
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

            Spacer(modifier = Modifier.height(52.dp))

            Text(
                text = "Dates",
                fontFamily = Montserrat,
                fontWeight = FontWeight.Normal,
                color = White,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 5.dp)
            )


            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ){
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

            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Guests",
                fontFamily = Montserrat,
                fontWeight = FontWeight.Normal,
                color = White,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 5.dp)
            )

            var guests by remember { mutableStateOf("") }
            SpacesTextField(
                text = guests,
                onValueChange ={guests=it},
                placeholder = "1 People",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(75.dp))
            SpacesButton(
                text = "Search",
                onClick = { TODO() }
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