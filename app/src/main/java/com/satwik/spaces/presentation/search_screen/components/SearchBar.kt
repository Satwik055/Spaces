package com.satwik.spaces.presentation.search_screen.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.satwik.spaces.R
import com.satwik.spaces.presentation.theme.Black
import com.satwik.spaces.presentation.theme.Montserrat
import com.satwik.spaces.presentation.theme.Purple
import com.satwik.spaces.presentation.theme.White


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier:Modifier = Modifier,
    query: String,
    onQueryChange: (String) -> Unit,
    placeholder:String,
    fontFamily:FontFamily = Montserrat,
    leadingButtonOnClick:() -> Unit,
    trailButtonOnClick:() ->Unit,
    @DrawableRes
    leadingButtonIcon:Int = R.drawable.ic_arrow_left,
    @DrawableRes
    trailButtonIcon:Int = R.drawable.ic_cross,
    autoFocus:Boolean = false

){
    val focusRequester = remember{FocusRequester()}
    if(autoFocus){
        LaunchedEffect(Unit){
            focusRequester.requestFocus()
        }
    }
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .focusRequester(focusRequester),

        value = query,

        onValueChange = onQueryChange,

        colors = TextFieldDefaults.textFieldColors(
            cursorColor = Purple,
            containerColor = Black,
            focusedIndicatorColor = Purple,
            unfocusedIndicatorColor = White
        ),
        singleLine = true,

        textStyle = TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Normal),

        trailingIcon = {
            IconButton(onClick = trailButtonOnClick,
            ) {
                Icon(
                    painter = painterResource(id = trailButtonIcon),
                    contentDescription = null,
                    tint = White,
                )
            }
        },
        leadingIcon = {
            IconButton(onClick = leadingButtonOnClick,
            ) {
                Icon(
                    painter = painterResource(id = leadingButtonIcon),
                    contentDescription = null,
                    tint = White,
                )
            }
        },

        placeholder = {
            Text(
                text = placeholder,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Normal
            )
        },
    )
}











@Preview
@Composable
fun SearchBarPreview(){
    var text by remember { mutableStateOf("") }
    SearchBar(
        query = text,
        onQueryChange = {text = it},
        placeholder = "Search for workspaces",
        trailButtonOnClick = { /*TODO*/ },
        leadingButtonOnClick = { /*TODO*/ })
}
