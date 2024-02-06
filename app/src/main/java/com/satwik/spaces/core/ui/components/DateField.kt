package com.satwik.spaces.core.ui.components

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maxkeppeker.sheets.core.models.base.UseCaseState
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.satwik.spaces.core.ui.theme.DarkGrey
import com.satwik.spaces.core.ui.theme.Grey
import com.satwik.spaces.core.ui.theme.White
import com.satwik.spaces.core.ui.theme.poppins
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DateFeild(
    text:String,
    onClick: () -> Unit
){
    Box(
        modifier = Modifier
            .width(183.dp)
            .height(53.dp)
            .background(color = DarkGrey, shape = RoundedCornerShape(5.dp))
            .clickable { onClick.invoke() }
    ) {
        Text(
            text = text,
            fontFamily = poppins,
            fontWeight = FontWeight.Normal,
            color = Color.White,
            fontSize = 15.sp,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 10.dp)
        )

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun DateFieldPreview(){


}