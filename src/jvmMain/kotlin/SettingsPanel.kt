import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import components.PropertySlider

// Based on: https://github.com/antonarhipov/compose-for-desktop-samples/blob/main/src/main/kotlin/SettingsPanel.kt

const val MIN_PLANET_RADIUS = 300f
const val MAX_PLANET_RADIUS = 550f

const val MIN_MOON_RADIUS = 75f
const val MAX_MOON_RADIUS = 150f

data class Settings(
    val planetRadius: Float = 400f,
    val moonRadius: Float = 100f
)

@Preview
@Composable
fun SettingsPanel(settings: Settings, onValueChange: (Settings) -> Unit) {
    LazyColumn(
        modifier = Modifier.width(250.dp)
    ) {
        item {
            Text(
                "Settings",
                color = MaterialTheme.colors.primaryVariant,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp)
            )
        }
        item {
            PropertySlider(
                settings.planetRadius,
                MIN_PLANET_RADIUS,
                MAX_PLANET_RADIUS,
                "Planet radius"
            ) { newValue -> onValueChange(settings.copy(planetRadius = newValue)) }
        }
        item {
            PropertySlider(
                settings.moonRadius,
                MIN_MOON_RADIUS,
                MAX_MOON_RADIUS,
                "Moon radius"
            ) { newValue -> onValueChange(settings.copy(moonRadius = newValue)) }
        }
    }
}