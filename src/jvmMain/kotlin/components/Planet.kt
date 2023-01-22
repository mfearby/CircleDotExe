package components

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import kotlin.math.cos
import kotlin.math.sin

fun DrawScope.drawPlanet(
    angle: Float = 0f,
    distance: Float = 0f,
    offset: Offset = Offset(0f, 0f),
    radius: Float = 70f,
    color: Color = Color.Blue,
    moonRadius: Float? = null,
    moonAngle: Float? = null,
    moonDistance: Float? = null
) {
    val planetOffset = calculateOffset(offset, angle, distance)

    drawCircle(
        color = color,
        radius = radius,
        center = planetOffset,
        style = Fill
    )

    if (moonRadius != null && moonAngle != null && moonDistance != null) {
        val moonOffset = calculateOffset(planetOffset, moonAngle, moonDistance)
        drawCircle(
            color = Color.White,
            radius = moonRadius,
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