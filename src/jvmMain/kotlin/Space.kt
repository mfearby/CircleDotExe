import androidx.compose.animation.core.rememberInfiniteTransition
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
import components.orbit

@Composable
fun Space(settings: Settings) {
    // Creates an [InfiniteTransition] instance for managing child animations.
    val infiniteTransition = rememberInfiniteTransition()

    val earthAngle by infiniteTransition.orbit(10000)
    val moonAngle by infiniteTransition.orbit(2000)

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

            drawPlanet(
                angle = earthAngle,
                distance = settings.planetDistance,
                color = Color.Blue,
                radius = 25f,
                offset = Offset(middle.x, middle.y),
                moonRadius = 10f,
                moonAngle = moonAngle,
                moonDistance = settings.moonDistance
            )
        }
    }
}