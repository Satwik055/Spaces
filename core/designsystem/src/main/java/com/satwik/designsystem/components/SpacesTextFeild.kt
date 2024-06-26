package com.satwik.designsystem.components

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.satwik.designsystem.theme.Grey
import com.satwik.designsystem.theme.LightGrey
import com.satwik.designsystem.theme.Purple
import com.satwik.designsystem.theme.poppins

@Composable
fun SpacesTextField(
    modifier: Modifier = Modifier,
    text:String,
    fontFamily: FontFamily = poppins,
    onValueChange: (String) -> Unit,
    placeholder:String,
    errorText: String = "",
    enabled:Boolean = true,
    isPassword:Boolean = false,
    isError:Boolean = false
){
    OutlinedTextField(
        modifier = modifier,
        value = text,
        enabled = enabled,
        onValueChange = onValueChange,
        isError = isError,
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            cursorColor = Purple,
            focusedBorderColor = Purple,
            unfocusedBorderColor = Grey,
            errorBorderColor = Color.Red,
        ),
        singleLine = true,
        supportingText = { Text(text = errorText,fontFamily = poppins, color = Color.Red, fontSize = 13.sp)},
        textStyle = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Normal, fontSize = 16.sp, color = Color.White),
        placeholder = {
            Text(
                text = placeholder,
                color = LightGrey,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Normal
            )
        },
        visualTransformation =
        if(isPassword){ PasswordVisualTransformation(mask = '\u25CF')}
        else { VisualTransformation.None },
    )

}

@Preview
@Composable
fun PreviewOutlinedTextField(){

}