import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.unit.dp
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
            drawCircle(
                color = Color.Blue,
                radius = 75f,
                center = Offset(
                    this.center.x + offsetX,
                    this.center.y + offsetY
                ),
                style = Fill,
            )
        }
    }
}