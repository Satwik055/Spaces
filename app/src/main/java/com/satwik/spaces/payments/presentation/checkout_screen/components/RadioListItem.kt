package com.satwik.spaces.payments.presentation.checkout_screen.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satwik.spaces.R
import com.satwik.spaces.core.theme.Montserrat
import com.satwik.spaces.core.theme.White

@Composable
fun RadioListItem(
    @DrawableRes
    icon:Int,
    text:String,
    selected:Boolean
){
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.align(Alignment.CenterStart),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = icon ), contentDescription = null)
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = text,
                fontFamily = Montserrat,
                fontWeight = FontWeight.Normal,
                color = White,
                fontSize = 15.sp,
            )
        }

        RadioButton(
            selected = selected,
            onClick = { /*TODO*/ },
            modifier = Modifier.align(Alignment.CenterEnd),
        )
    }

}

@Preview
@Composable
fun RadioListItemPreview(){
    RadioListItem(R.drawable.ic_creditcard, "Credit/Debit Card", true)
}

