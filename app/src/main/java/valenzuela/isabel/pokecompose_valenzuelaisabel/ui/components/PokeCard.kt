package valenzuela.isabel.pokecompose_valenzuelaisabel.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import valenzuela.isabel.pokecompose_valenzuelaisabel.model.Pokemon
import valenzuela.isabel.pokecompose_valenzuelaisabel.model.samplePokemons

@Composable
fun PokeCard(
    pokemon: Pokemon,
    onCardClick: () -> Unit
    ) {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable(){onCardClick()},
        elevation = CardDefaults.elevatedCardElevation(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(15.dp)
        ) {
            Image(
                painter = painterResource(pokemon.image),
                contentDescription = pokemon.nombre,
                contentScale = ContentScale.Fit,
                alignment = Alignment.Center,
                modifier = Modifier
                    .size(90.dp)
            )
            Column(
                modifier = Modifier
                    .padding(12.dp)
            ) {
                Text(
                    text = pokemon.nombre,
                    fontFamily = FontFamily.Serif,
                    fontSize = 18.sp,
                    fontWeight = Bold,
                    modifier = Modifier
                        .padding(5.dp)
                )
                Text(
                    text = pokemon.tipo,
                    modifier = Modifier
                        .padding(5.dp)
                )
            }
        }
    }
}

@Preview()
@Composable
fun PokeCardPreview() {
    PokeCard(samplePokemons[0], {})
}