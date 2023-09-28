package com.satwik.spaces.core.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.google.android.gms.common.internal.FallbackServiceBroker
import com.satwik.spaces.properties.presentation.theme.Grey
import com.satwik.spaces.properties.presentation.theme.LightGrey
import com.satwik.spaces.properties.presentation.theme.Montserrat
import com.satwik.spaces.properties.presentation.theme.Purple

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpacesTextField(
    modifier: Modifier = Modifier,
    text:String,
    fontFamily: FontFamily = Montserrat,
    onValueChange: (String) -> Unit,
    placeholder:String,
    errorText: String = "",
    isError:Boolean = false


){

    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = onValueChange,
        isError = isError,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = Purple,
            containerColor = Color.Transparent,
            focusedBorderColor = Purple,
            unfocusedBorderColor = Grey,
            errorBorderColor = Color.Red
        ),
        singleLine = true,
        supportingText = { Text(text = errorText, color = Color.Red, fontSize = 13.sp)},
        textStyle = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Normal, fontSize = 16.sp, color = Color.White),
        placeholder = {
            Text(
                text = placeholder,
                color = LightGrey,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Normal
            )
        }
    )

}

@Preview
@Composable
fun PreviewOutlinedTextField(){

}