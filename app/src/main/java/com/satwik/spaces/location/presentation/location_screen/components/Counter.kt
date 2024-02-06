package com.satwik.spaces.location.presentation.location_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satwik.spaces.R
import com.satwik.spaces.core.components.SpacesIconButton
import com.satwik.spaces.core.theme.poppins
import com.satwik.spaces.core.theme.White
import com.satwik.spaces.location.presentation.location_screen.LocationScreenViewModel

@Composable
fun Counter(
    viewModel:LocationScreenViewModel
){
    var peopleCount by remember { mutableIntStateOf(1) }


    LaunchedEffect(peopleCount){
        viewModel.savePeople(peopleCount.toString())
    }

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
                icon = R.drawable.ic_plus,
                onClick = { peopleCount++ }
            )

            Text(
                text = peopleCount.toString(),
                fontFamily = poppins,
                fontWeight = FontWeight.Normal,
                color = White,
                fontSize = 17.sp,
            )

            SpacesIconButton(
                icon = R.drawable.ic_minus,
                onClick = {
                    if(peopleCount > 1 ) {
                        peopleCount--
                    }
                }
            )
        }
    }
}

