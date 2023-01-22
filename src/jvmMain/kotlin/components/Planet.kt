package components

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill

fun DrawScope.drawPlanet(
    offset: Offset = Offset(0f, 0f),
    radius: Float = 70f,
    color: Color = Color.Blue
) {
    drawCircle(
        color = color,
        radius = radius,
        center = Offset(offset.x, offset.y),
        style = Fill,
    )
}