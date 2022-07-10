package com.example.baseapp.data.pokemons

import android.content.res.AssetManager
import com.example.baseapp.data.serializer.JsonSerializer
import com.example.baseapp.di.IoDispatcher
import com.example.baseapp.model.Pokemon
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

private const val POKEMONS_FILE_NAME = "pokemons.json"

class PokemonsFileDataSourceImpl @Inject constructor(
    private val assetManager: AssetManager,
    private val serializer: JsonSerializer<List<Pokemon>>,
    @IoDispatcher private val coroutineDispatcher: CoroutineDispatcher,
) : PokemonsLocalDataSource {
    @Suppress("BlockingMethodInNonBlockingContext")
    override suspend fun readFile(): List<Pokemon> = withContext(coroutineDispatcher) {
        val inputStream = assetManager.open(POKEMONS_FILE_NAME)
        serializer.decodeFromStream(inputStream)
    }
}