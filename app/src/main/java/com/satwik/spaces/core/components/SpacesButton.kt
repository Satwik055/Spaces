package com.satwik.spaces.core.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satwik.spaces.core.theme.Montserrat
import com.satwik.spaces.core.theme.Purple
import com.satwik.spaces.core.theme.White

enum class ButtonType{
    REGULAR,
    LOADING
}


@Composable
fun SpacesButton(
    type:ButtonType = ButtonType.REGULAR,
    modifier:Modifier = Modifier,
    color:Color = Purple,
    textColor:Color = White,
    text:String,
    fontSize:TextUnit = 18.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    onClick: () -> Unit
){
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = color),
        modifier= modifier
            .fillMaxWidth()
            .height(55.dp)
    ) {
        when(type){
            ButtonType.REGULAR ->
                Text(
                text = text,
                fontFamily = Montserrat,
                fontWeight = fontWeight,
                color = textColor,
                fontSize = fontSize
                )
            ButtonType.LOADING ->
                CircularProgressIndicator(color = White, modifier = Modifier.size(25.dp), strokeWidth = 2.dp)
        }
    }
}