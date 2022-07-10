package com.example.baseapp.ui.pokemonDetails

data class PokemonDetailsUiState(
    val isLoading: Boolean = false,
    val name: String = "",
    val description: String = "",
    val imageFileName: String = "",
)