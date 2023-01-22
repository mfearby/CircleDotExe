package components

import androidx.compose.animation.core.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State

@Composable
fun InfiniteTransition.orbit(durationMillis: Int): State<Float> {
    // position on circle arc (Top = 270, Right = 360, Bottom = 90, Left = 180)
    return animateValue(
        initialValue = 0f,
        targetValue = 359f,
        Float.VectorConverter,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )
}

