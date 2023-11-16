package com.satwik.spaces.core.components


import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.satwik.spaces.core.theme.Black
import com.satwik.spaces.core.theme.DarkGrey

@Composable
fun AnimatedShimmerText() {
    val shimmerColors = listOf(
        DarkGrey,
        DarkGrey.copy(alpha = 0.1f),
        DarkGrey,
    )

    val transition = rememberInfiniteTransition(label = "")
    val translateAnim = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end = Offset(x = translateAnim.value, y = translateAnim.value)
    )

    Spacer(
        modifier = Modifier
            .height(20.dp)
            .width(100.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(brush)
    )
}


@Composable
@Preview
fun ShimmerTextPreview() {
    AnimatedShimmerText()
}





