package com.satwik.spaces.core.components


import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedShimmer() {
    val shimmerColors = listOf(
        Color(0xFFEBEBF4),
        Color(0xFFF4F4F4),
        Color(0xFFEBEBF4),
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

    ShimmerCard(brush = brush)
}

@Composable
fun ShimmerCard(brush: Brush) {
    Spacer(
        modifier = Modifier
            .height(173.dp)
            .width(287.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(brush)
    )

}

@Composable
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
fun ShimmerCardPreview() {
 ShimmerCard(brush =  Brush.linearGradient(
     listOf(
         Color.LightGray.copy(alpha = 0.6f),
         Color.LightGray.copy(alpha = 0.2f),
         Color.LightGray.copy(alpha = 0.6f),
     )
 ))
}





