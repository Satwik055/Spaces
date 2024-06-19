package com.satwik.location.presentation.location_screen.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satwik.designsystem.components.SpacesIconButton
import com.satwik.designsystem.theme.White
import com.satwik.designsystem.theme.poppins
import com.satwik.location.presentation.location_screen.LocationScreenViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Counter(
    viewModel: LocationScreenViewModel
){
    val peopleCount = viewModel.getPeople().collectAsState(initial = "1")

    Box (
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = "People",
            fontFamily = poppins,
            fontWeight = FontWeight.Normal,
            color = White,
            fontSize = 18.sp,
            modifier = Modifier.align(Alignment.CenterStart)
        )
        Row (
            modifier = Modifier.align(Alignment.CenterEnd),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ){
            SpacesIconButton(
                icon = com.satwik.designsystem.R.drawable.ic_plus,
                onClick = { viewModel.savePeople(peopleCount.value.toInt().plus(1).toString()) }
            )

            Text(
                text = peopleCount.value,
                fontFamily = poppins,
                fontWeight = FontWeight.Normal,
                color = White,
                fontSize = 17.sp,
            )

            SpacesIconButton(
                icon = com.satwik.designsystem.R.drawable.ic_minus,
                onClick = {
                    if(peopleCount.value.toInt() > 1 ) {
                        viewModel.savePeople(peopleCount.value.toInt().minus(1).toString())
                    }
                }
            )
        }
    }
}

