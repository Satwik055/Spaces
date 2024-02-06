package com.satwik.spaces.core.ui.components


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
import com.satwik.spaces.core.ui.theme.Black
import com.satwik.spaces.core.ui.theme.DarkGrey

enum class CardSize{
    SMALL,
    LARGE
}

@Composable
fun AnimatedShimmerCard(cardSize: CardSize) {
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
        modifier =
        when (cardSize) {
            CardSize.LARGE ->
                Modifier
                    .height(204.dp)
                    .fillMaxWidth()

            CardSize.SMALL ->
                Modifier
                    .height(173.dp)
                    .width(287.dp)
        }
            .clip(RoundedCornerShape(10.dp))
            .background(brush),
    )
}



@Composable
@Preview
fun ShimmerCardPreview() {

    Column {
        AnimatedShimmerCard(cardSize = CardSize.SMALL)
        AnimatedShimmerCard(cardSize = CardSize.LARGE)
    }



}





