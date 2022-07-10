package com.example.baseapp.data.pokemons

import com.example.baseapp.model.Pokemon
import javax.inject.Inject

class PokemonsRepositoryImpl @Inject constructor(
    private val dataSource: PokemonsLocalDataSource
) : PokemonsRepository {
    private lateinit var cache: List<Pokemon>

    override suspend fun listPokemons(): List<Pokemon> = fetchPokemons()

    override suspend fun getPokemon(pokemonId: Int): Pokemon {
        val pokemons = fetchPokemons()
        val pokemon = pokemons.find { pokemon -> pokemon.id == pokemonId }
        return pokemon!!
    }

    private suspend fun fetchPokemons(): List<Pokemon> {
        if (this::cache.isInitialized) return cache
        cache = dataSource.readFile()
        return cache
    }
}