import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import components.drawPlanet
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Space(settings: Settings) {
    // position on circle (Top = 270, Right = 360, Bottom = 90, Left = 180)
    val angle = 180
    val rad = Math.toRadians(angle.toDouble())

    val radius = settings.planetRadius // distance from centre
    val offsetX = radius * cos(rad).toFloat()
    val offsetY = radius * sin(rad).toFloat()

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

            val earthOffset = Offset(
                middle.x + offsetX,
                middle.y + offsetY
            )
            drawPlanet(
                color = Color.Blue,
                radius = 25f,
                offset = earthOffset
            )
        }
    }
}