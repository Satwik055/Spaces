package com.satwik.spaces.properties.presentation.detail_screen.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.satwik.spaces.core.theme.Purple

@OptIn(ExperimentalFoundationApi::class)
@Composable

fun ImageSlider(
    listOfUrl:List<String>,
    modifier:Modifier = Modifier,
    cornerRadius:Dp = 10.dp
){
    val pagerState = rememberPagerState()

    HorizontalPager(
        pageCount = listOfUrl.size,
        state = pagerState,
        key = { listOfUrl[it] },
        modifier = Modifier.clip(RoundedCornerShape(cornerRadius)),
    ) {
        SubcomposeAsyncImage(
            model = listOfUrl[it],
            contentScale = ContentScale.Crop,
            loading = { CircularProgressIndicator(color= Purple, modifier = Modifier.size(40.dp)) },
            contentDescription = null,
            modifier = modifier.height(364.dp).fillMaxWidth()
        )
    }
}