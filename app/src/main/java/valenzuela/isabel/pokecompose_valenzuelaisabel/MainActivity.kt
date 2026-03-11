package valenzuela.isabel.pokecompose_valenzuelaisabel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import valenzuela.isabel.pokecompose_valenzuelaisabel.navigation.AppNavigation
import valenzuela.isabel.pokecompose_valenzuelaisabel.ui.theme.PokeCompose_ValenzuelaIsabelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokeCompose_ValenzuelaIsabelTheme {
                // Llamar al controlador
                AppNavigation()
            }
        }
    }
}