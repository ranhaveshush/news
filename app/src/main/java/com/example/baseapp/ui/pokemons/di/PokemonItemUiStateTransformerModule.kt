package com.example.baseapp.ui.pokemons.di

import com.example.baseapp.ui.pokemons.transformer.PokemonItemUiStateTransformer
import com.example.baseapp.ui.pokemons.transformer.PokemonItemUiStateTransformerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class PokemonItemUiStateTransformerModule {
    @Binds
    abstract fun bindTransformer(transformer: PokemonItemUiStateTransformerImpl): PokemonItemUiStateTransformer
}