package com.example.baseapp.data.pokemons

import com.example.baseapp.data.Result
import com.example.baseapp.model.Pokemon
import javax.inject.Inject

class PokemonsRepositoryImpl @Inject constructor(
    private val dataSource: PokemonsLocalDataSource
) : PokemonsRepository {
    private lateinit var cache: List<Pokemon>

    override suspend fun listPokemons(): Result<List<Pokemon>> = fetchPokemons()

    override suspend fun getPokemon(pokemonId: Int): Result<Pokemon> {
        val result = fetchPokemons()
        if (result !is Result.Success) return Result.error<Pokemon>(IllegalArgumentException("Couldn't fetch pokemons"))
        val pokemon = result.data.find { pokemon -> pokemon.id == pokemonId }
        return if (pokemon != null) {
            Result.success(pokemon)
        } else {
            Result.error<Pokemon>(IllegalArgumentException("Couldn't find pokemon with id $pokemonId"))
        }
    }

    private suspend fun fetchPokemons(): Result<List<Pokemon>> {
        if (this::cache.isInitialized) return Result.success(cache)
        return try {
            cache = dataSource.readFile()
            Result.success(cache)
        } catch (exception: Exception) {
            Result.error<List<Pokemon>>(IllegalArgumentException("Couldn't fetch pokemons"))
        }
    }
}