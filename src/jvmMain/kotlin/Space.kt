import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import components.drawPlanet
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Space(settings: Settings) {
    // Creates an [InfiniteTransition] instance for managing child animations.
    val infiniteTransition = rememberInfiniteTransition()

    // position on circle arc (Top = 270, Right = 360, Bottom = 90, Left = 180)
    val angle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 359f,
        animationSpec = infiniteRepeatable(
            animation = tween(10000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    val moonAngle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 359f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    MaterialTheme {
        Canvas(
            Modifier
                .fillMaxHeight()
                .width(850.dp)
                .background(Color.Black)
        ) {
            val middle = this.center
            drawPlanet(
                color = Color(255, 184, 0),
                offset = Offset(middle.x, middle.y)
            )

            val radius = settings.planetRadius // distance from centre
            val rad = Math.toRadians(angle.toDouble())
            val offsetX = radius * cos(rad).toFloat()
            val offsetY = radius * sin(rad).toFloat()
            val earthOffset = Offset(
                middle.x + offsetX,
                middle.y + offsetY
            )
            drawPlanet(
                color = Color.Blue,
                radius = 25f,
                offset = earthOffset
            )

            val moonRadius = settings.moonRadius
            val moonRad = Math.toRadians(moonAngle.toDouble())
            val moonOffsetX = moonRadius * cos(moonRad).toFloat()
            val moonOffsetY = moonRadius * sin(moonRad).toFloat()
            val moonOffset = Offset(
                earthOffset.x + moonOffsetX,
                earthOffset.y + moonOffsetY
            )

            drawPlanet(
                color = Color.White,
                radius = 10f,
                offset = moonOffset
            )
        }
    }
}