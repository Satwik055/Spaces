package com.satwik.designsystem.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satwik.designsystem.theme.DarkGrey
import com.satwik.designsystem.theme.poppins

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