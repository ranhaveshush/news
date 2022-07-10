package com.example.baseapp.ui.pokemons.transformer

import com.example.baseapp.model.Pokemon
import com.example.baseapp.model.imageFileName
import com.example.baseapp.ui.pokemons.PokemonItemUiState
import javax.inject.Inject

class PokemonItemUiStateTransformerImpl @Inject constructor() : PokemonItemUiStateTransformer {
    override fun transform(data: Pokemon): PokemonItemUiState = PokemonItemUiState(
        id = data.id,
        name = data.name,
        imageFileName = data.imageFileName
    )
}