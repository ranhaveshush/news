package com.example.baseapp.data.pokemons

import com.example.baseapp.model.Pokemon

interface PokemonsRepository {
    suspend fun listPokemons(): List<Pokemon>

    suspend fun getPokemon(pokemonId: Int): Pokemon
}