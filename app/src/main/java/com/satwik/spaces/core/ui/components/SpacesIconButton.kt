package com.satwik.spaces.core.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satwik.spaces.R
import com.satwik.spaces.core.ui.theme.DarkGrey
import com.satwik.spaces.core.ui.theme.Purple
import com.satwik.spaces.core.ui.theme.White

@Composable
fun SpacesIconButton(
    modifier:Modifier = Modifier,
    @DrawableRes
    icon:Int,
    buttonColor:Color = DarkGrey,
    onClick: () -> Unit
){
    Box(
        modifier = Modifier
            .size(40.dp)
            .background(color = buttonColor, shape = RoundedCornerShape(10.dp))
            .clickable { onClick.invoke() }
    ){
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier.align(Alignment.Center)
        )

    }
}

@Preview
@Composable
fun MyPreview() {
    SpacesIconButton(icon = R.drawable.ic_plus) {
        
    }
}