package com.example.baseapp.ui.navigation

sealed class Screen(val route: String) {
    object Headlines : Screen("headlines")
    object Article : Screen("article?url={url}") {
        fun createRoute(url: String) = "article?url=$url"
    }

    object Pokemons : Screen("pokemons")
    object PokemonDetails : Screen("pokemon/{pokemonId}") {
        fun createRoute(pokemonId: Int) = "pokemon/$pokemonId"
    }
}
