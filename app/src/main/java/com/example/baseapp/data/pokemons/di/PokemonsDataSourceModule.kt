package com.example.baseapp.data.pokemons.di

import com.example.baseapp.data.pokemons.PokemonsFileDataSourceImpl
import com.example.baseapp.data.pokemons.PokemonsLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class PokemonsDataSourceModule {
    @Binds
    abstract fun bindDataSource(dataSource: PokemonsFileDataSourceImpl): PokemonsLocalDataSource
}