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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.satwik.spaces.R
import com.satwik.spaces.presentation.theme.Montserrat
import com.satwik.spaces.presentation.theme.White


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier:Modifier = Modifier,
    query: String,
    onQueryChange: (String) -> Unit,
    placeholder:String,
    backButtonOnClick:() -> Unit,
    cancelButtonOnClick:() ->Unit,
    @DrawableRes
    backButtonIcon:Int = R.drawable.ic_arrow_left,
    @DrawableRes
    cancelButtonIcon:Int = R.drawable.ic_hamburger
){

    TextField(
        modifier = modifier
            .fillMaxWidth(),
        value = query,
        onValueChange = onQueryChange,
        singleLine = true,
        textStyle = TextStyle(fontFamily = Montserrat, fontWeight = FontWeight.Normal),
        trailingIcon = {
            IconButton(onClick = backButtonOnClick,
            ) {
                Icon(
                    painter = painterResource(id = backButtonIcon),
                    contentDescription = null,
                    tint = White,
                )
            } },
        leadingIcon = {
            IconButton(onClick = cancelButtonOnClick,
            ) {
                Icon(
                    painter = painterResource(id = cancelButtonIcon),
                    contentDescription = null,
                    tint = White,
                )
            } },
        placeholder = {
            Text(
                text = placeholder,
                fontFamily = Montserrat,
                fontWeight = FontWeight.Normal
            ) },

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
        backButtonOnClick = { /*TODO*/ },
        cancelButtonOnClick = { /*TODO*/ })
}
