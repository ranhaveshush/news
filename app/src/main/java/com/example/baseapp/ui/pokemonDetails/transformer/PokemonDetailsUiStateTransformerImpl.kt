package com.example.baseapp.ui.pokemonDetails.transformer

import com.example.baseapp.model.Pokemon
import com.example.baseapp.model.imageFileName
import com.example.baseapp.ui.pokemonDetails.PokemonDetailsUiState
import javax.inject.Inject

class PokemonDetailsUiStateTransformerImpl @Inject constructor() :
    PokemonDetailsUiStateTransformer {
    override fun transform(data: Pokemon): PokemonDetailsUiState = PokemonDetailsUiState(
        name = data.name,
        description = data.description,
        imageFileName = data.imageFileName
    )
}