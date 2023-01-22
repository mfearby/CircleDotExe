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

const val MIN_PLANET_DISTANCE = 300f
const val MAX_PLANET_DISTANCE = 550f

const val MIN_MOON_DISTANCE = 75f
const val MAX_MOON_DISTANCE = 150f

data class Settings(
    val planetDistance: Float = 400f,
    val moonDistance: Float = 100f
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
                settings.planetDistance,
                MIN_PLANET_DISTANCE,
                MAX_PLANET_DISTANCE,
                "Planet distance"
            ) { newValue -> onValueChange(settings.copy(planetDistance = newValue)) }
        }
        item {
            PropertySlider(
                settings.moonDistance,
                MIN_MOON_DISTANCE,
                MAX_MOON_DISTANCE,
                "Moon distance"
            ) { newValue -> onValueChange(settings.copy(moonDistance = newValue)) }
        }
    }
}