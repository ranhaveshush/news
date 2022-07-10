package com.example.baseapp.data.pokemons

import com.example.baseapp.data.Result
import com.example.baseapp.model.Pokemon

interface PokemonsRepository {
    suspend fun listPokemons(): Result<List<Pokemon>>

    suspend fun getPokemon(pokemonId: Int): Result<Pokemon>
}