package valenzuela.isabel.pokecompose_valenzuelaisabel.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import valenzuela.isabel.pokecompose_valenzuelaisabel.R
import valenzuela.isabel.pokecompose_valenzuelaisabel.model.Pokemon
import valenzuela.isabel.pokecompose_valenzuelaisabel.model.samplePokemons
import valenzuela.isabel.pokecompose_valenzuelaisabel.ui.screens.LoginScreen
import valenzuela.isabel.pokecompose_valenzuelaisabel.ui.screens.PokeDetail
import valenzuela.isabel.pokecompose_valenzuelaisabel.ui.screens.PokeDex

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.LOGIN_SCREEN) {
        composable(Routes.LOGIN_SCREEN) {
            LoginScreen({
                navController.navigate(Routes.POKEMON_LIST_SCREEN)
            })
        }

        composable(Routes.POKEMON_LIST_SCREEN) {
            PokeDex(onPokemonClick = { pokemon -> // Obtiene el pokemon que se mandó desde PokeDex
                navController.navigate("detail/${pokemon.id}") // Pone el id como parámetro
            })
        }

        composable(
            route = Routes.POKEMON_DETAIL,
            arguments = listOf(navArgument("pokemonId") {
                type = NavType.IntType
            })
        ) {
            // Cada pantalla que se visita se guarda como una entrada en una pila (back stack),
            // y backStackEntry es el objeto que representa una de esas pantallas dentro de esa pila.
            backStackEntry ->

            // Obtiene los argumentos (el id)
            val id = backStackEntry.arguments?.getInt("pokemonId")

            // Obtiene el objeto pokemon de la lista mediante el id
            val pokemonSeleccionado = samplePokemons.find { it.id == id }

            // Si obtuvo alguno, abre el poke detail pasándole el pokemon
            pokemonSeleccionado?.let {
                PokeDetail(it)
            }
        }
    }
}

// Rutas de la app
object Routes {
    const val LOGIN_SCREEN = "login"
    const val  POKEMON_LIST_SCREEN = "list"

    //Para que acepte parámetros
    const val POKEMON_DETAIL = "detail/{pokemonId}"
}