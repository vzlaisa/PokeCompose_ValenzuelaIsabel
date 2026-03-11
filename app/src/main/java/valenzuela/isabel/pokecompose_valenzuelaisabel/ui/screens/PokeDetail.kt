package valenzuela.isabel.pokecompose_valenzuelaisabel.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import valenzuela.isabel.pokecompose_valenzuelaisabel.model.Pokemon
import valenzuela.isabel.pokecompose_valenzuelaisabel.model.samplePokemons

@Composable
fun PokeDetail(
    pokemon: Pokemon
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFFE0AFC9)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .padding(30.dp, 50.dp)
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(16.dp))
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Titulo
            Row() {
                Text(
                    text = pokemon.nombre,
                    fontFamily = FontFamily.Serif,
                    fontSize = 18.sp,
                    fontWeight = Bold,
                    modifier = Modifier
                        .padding(5.dp)
                )
                Text(
                    text = " N.° " + pokemon.id,
                    fontFamily = FontFamily.Serif,
                    fontSize = 18.sp,
                    fontWeight = Bold,
                    color = Color(0xFF808080),
                    modifier = Modifier
                        .padding(5.dp)
                )
            }

            Spacer(
                modifier = Modifier
                    .height(15.dp)
            )

            // Cuadrado de info
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {

                // Imagen
                Column(
                    modifier = Modifier
                        .weight(0.40f)
                        .padding(top = 18.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(pokemon.image),
                        contentDescription = "Pokemon " + pokemon.nombre,
                        alignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentScale = ContentScale.Fit
                    )
                }

                // Carta de info
                Column(
                    modifier = Modifier
                        .weight(0.60f)
                        .padding(12.dp)
                ) {
                    Card() {
                        Column(
                            modifier = Modifier
                                .background(Color(0xFF30a7d7))
                                .padding(10.dp)
                        ) {
                            Row() {
                                PokemonInfoRow("Altura",pokemon.altura.toString() + " m", Modifier.weight(0.4f))
                                PokemonInfoRow("Peso", pokemon.peso.toString() + " kg", Modifier.weight(0.6f))
                            }

                            Spacer(
                                modifier = Modifier
                                    .height(10.dp)
                            )

                            Row() {
                                PokemonInfoRow("Tipo", pokemon.tipo, Modifier.weight(0.4f))
                                PokemonInfoRow("Categoría", pokemon.categoria, Modifier.weight(0.6f))
                            }
                        }
                    }

                    Spacer(
                        modifier = Modifier
                            .height(10.dp)
                    )

                    // Tipo
                    Text(
                        text = "Tipo",
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontSize = 11.sp
                        ),
                        modifier = Modifier
                            .padding(5.dp)
                    )
                    Box(
                        modifier = Modifier
                        .padding(5.dp)
                        .background(colorSegunTipo(pokemon.tipo), shape = RoundedCornerShape(5.dp))
                        .padding(20.dp, 4.dp)
                    ){
                        Text(
                            text = pokemon.tipo,
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontSize = 11.sp
                            )
                        )
                    }
                }
            }

            // Descripción
            Text(
                text = pokemon.descripcion,
                style = MaterialTheme.typography.bodySmall.copy(
                    lineHeight = 15.sp
                ),
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .padding(5.dp)
            )

            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )
        }
    }
}

@Composable
private fun PokemonInfoRow(label: String, value: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
    ) {

        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall.copy(
                fontSize = 10.sp
            ),
            color = Color.White,
            fontWeight = Bold
        )

        Spacer(
            modifier = Modifier
                .height(6.dp)
        )

        Text(
            text = value,
            style = MaterialTheme.typography.bodySmall.copy(
                fontSize = 10.5.sp,
                color = Color.Black
            ),
        )
    }
}

private fun colorSegunTipo(tipo: String): Brush {
    return when(tipo.lowercase()){
        "normal" -> Brush.verticalGradient(
            colors = listOf(Color(0xFFA4ACAF), Color(0xFFA4ACAF))
        )

        "agua" -> Brush.verticalGradient(
            colors = listOf(Color(0xFF4592C4), Color(0xFF4592C4))
        )

        "planta" -> Brush.verticalGradient(
            colors = listOf(Color(0xFF9BCC50), Color(0xFF9BCC50))
        )

        "hada" -> Brush.verticalGradient(
            colors = listOf(Color(0xFFFCB8E8), Color(0xFFFCB8E8))
        )

        "volador" -> Brush.verticalGradient(
            colors = listOf(
                Color(0xFF3DC7EF), // mitad superior
                Color(0xFF3DC7EF),
                Color(0xFFBDB9B8), // mitad inferior
                Color(0xFFBDB9B8)
            )
        )

        else -> Brush.verticalGradient(
            colors = listOf(Color.Gray, Color.Gray)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PokeDetailPreview() {
    PokeDetail(samplePokemons[5])
}