package com.example.baseapp.ui.pokemonDetails.di

import com.example.baseapp.ui.pokemonDetails.transformer.PokemonDetailsUiStateTransformer
import com.example.baseapp.ui.pokemonDetails.transformer.PokemonDetailsUiStateTransformerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class PokemonDetailsUiStateTransformerModule {
    @Binds
    abstract fun bindTransformer(transformer: PokemonDetailsUiStateTransformerImpl): PokemonDetailsUiStateTransformer
}