package com.example.baseapp.data.pokemons.di

import com.example.baseapp.data.pokemons.PokemonsRepository
import com.example.baseapp.data.pokemons.PokemonsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class PokemonsRepositoryModule {
    @Binds
    abstract fun bindRepository(repository: PokemonsRepositoryImpl): PokemonsRepository
}