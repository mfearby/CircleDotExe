package components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Based on: https://github.com/antonarhipov/compose-for-desktop-samples/blob/main/src/main/kotlin/SettingsPanel.kt

@Composable
fun PropertySlider(
    initialValue: Float,
    minValue: Float,
    maxValue: Float,
    label: String,
    onChange: (Float) -> Unit,
) {
    var value by remember { mutableStateOf(initialValue) }
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        Row {
            Text(text = "$label: ", fontSize = 14.sp)
            Text(text = "%.2f".format(value), fontSize = 14.sp)
        }
        Slider(
            value = value,
            valueRange = minValue..maxValue,
            onValueChange = { value = it; onChange(value) },
            onValueChangeFinished = { onChange(value) }
        )
    }
}