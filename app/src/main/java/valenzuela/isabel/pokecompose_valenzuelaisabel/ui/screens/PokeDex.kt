package valenzuela.isabel.pokecompose_valenzuelaisabel.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import valenzuela.isabel.pokecompose_valenzuelaisabel.model.Pokemon
import valenzuela.isabel.pokecompose_valenzuelaisabel.model.samplePokemons
import valenzuela.isabel.pokecompose_valenzuelaisabel.ui.components.PokeCard

@Composable
fun PokeDex(
    onPokemonClick: (Pokemon) -> Unit
) {
    Column(
        modifier = Modifier
            .background(Color(0xFFE0AFC9))
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,       // Centra de arriba a abajo
        horizontalAlignment = Alignment.CenterHorizontally // Centra de izquierda a derecha
    ) {
        Text(
            text = "Mi Pokedex",
            modifier = Modifier
                .padding(0.dp, 50.dp, 0.dp, 0.dp),
            style = MaterialTheme.typography.headlineMedium
        )
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            // Cargar pokemones
            LazyColumn() {
                items(samplePokemons, { it.id }
                ) { pokemon ->
                    // Para abrir los detalles de cada pokemon
                    PokeCard(pokemon) { onPokemonClick(pokemon) }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokeDexPreview() {
    PokeDex( {})
}