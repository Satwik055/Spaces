package com.satwik.spaces.core.ui.nav_drawer

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satwik.spaces.R
import com.satwik.spaces.core.ui.theme.Purple
import com.satwik.spaces.core.ui.theme.White
import com.satwik.spaces.core.ui.theme.poppins


@Composable
fun DrawerItem(
    label:String,
    @DrawableRes
    icon:Int = R.drawable.ic_creditcard,
    onClick:() -> Unit,
    selected:Boolean = false
) {
    Box (modifier = Modifier.padding(horizontal = 15.dp)){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .background(color = if(selected){Purple} else{Color.Transparent})
                .height(55.dp)
                .padding(12.dp)
                .fillMaxWidth().clickable { onClick.invoke() }
        ) {
            Icon(painter = painterResource(id = icon), contentDescription = null, tint = White )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = label,
                color = White,
                fontWeight = FontWeight.Normal,
                style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
                fontSize = 18.sp,
                fontFamily = poppins
            )
        }
    }
}