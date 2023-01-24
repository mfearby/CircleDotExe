package components

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import kotlin.math.cos
import kotlin.math.sin

data class PlanetConfig(
    val radius: Float,
    val angle: Float,
    val distance: Float
)

fun DrawScope.drawPlanet(
    angle: Float = 0f,
    distance: Float = 0f,
    offset: Offset = Offset(0f, 0f),
    radius: Float = 70f,
    color: Color = Color.Blue,
    moon: PlanetConfig? = null
) {
    val planetOffset = calculateOffset(offset, angle, distance)

    drawCircle(
        color = color,
        radius = radius,
        center = planetOffset,
        style = Fill
    )

    moon?.let {
        val moonOffset = calculateOffset(planetOffset, it.angle, it.distance)
        drawCircle(
            color = Color.White,
            radius = it.radius,
            center = moonOffset,
            style = Fill
        )
    }
}

private fun calculateOffset(
    offset: Offset = Offset(0f, 0f),
    angle: Float,
    distance: Float
): Offset {
    return if (angle == 0f && distance == 0f) {
        offset
    } else {
        val rad = Math.toRadians(angle.toDouble())
        val offsetX = distance * cos(rad).toFloat()
        val offsetY = distance * sin(rad).toFloat()
        Offset(
            offset.x + offsetX,
            offset.y + offsetY
        )
    }
}