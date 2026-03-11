package valenzuela.isabel.pokecompose_valenzuelaisabel.model

import androidx.compose.runtime.remember
import valenzuela.isabel.pokecompose_valenzuelaisabel.R

data class Pokemon (
    val id: Int,
    val nombre: String,
    val tipo: String,
    val altura: Float,
    val peso: Float,
    val categoria: String,
    val descripcion: String,
    var image: Int) {
}

val samplePokemons =
    listOf<Pokemon>(
        Pokemon(132, "Ditto", "Normal", 0.3f, 4.0f, "Transformación", "Su habilidad para transformarse es perfecta, pero, si se le hace reír, perderá la fuerza y no podrá mantenerse transformado.",  R.drawable.pokemon_132),
        Pokemon(393, "Piplup", "Agua", 0.4f, 5.2f, "Pingüino", "No se le da bien andar. Se tropieza mucho, pero su orgullo le hace sacar pecho como si nada.", R.drawable.pokemon_393),
        Pokemon(35, "Clefairy", "Hada", 0.6f, 7.5f, "Hada", "En las noches de luna llena, Clefairy de diversos lugares se reúnen para bailar bajo su luz, la cual los hace flotar.", R.drawable.pokemon_35),
        Pokemon(54, "Psyduck", "Agua", 0.8f, 19.6f, "Pato",  "Padece continuamente dolores de cabeza. Cuando son muy fuertes, empieza a usar misteriosos poderes.", R.drawable.pokemon_54),
        Pokemon(821, "Rookidee", "Volador", 0.2f, 1.8f, "Pajarito", "Es de carácter valiente y temerario. Las marcas blancas que tiene alrededor de los ojos le sirven para espantar a los Pokémon más miedosos.",R.drawable.pokemon_821),
        Pokemon(1, "Bulbasaur", "Planta", 0.7f, 6.9f, "Semilla", "Tras nacer, crece alimentándose durante un tiempo de los nutrientes que contiene el bulbo de su lomo.", R.drawable.pokemon_1)
    )
