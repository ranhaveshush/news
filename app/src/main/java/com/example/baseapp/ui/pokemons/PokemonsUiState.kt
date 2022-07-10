package com.example.baseapp.ui.pokemons

data class PokemonsUiState(
    val isLoading: Boolean = false,
    val pokemons: List<PokemonItemUiState> = emptyList()
)