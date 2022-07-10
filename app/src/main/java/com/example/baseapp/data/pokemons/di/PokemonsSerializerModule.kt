package com.example.baseapp.data.pokemons.di

import com.example.baseapp.data.json.serializer.JsonSerializer
import com.example.baseapp.model.Pokemon
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import java.io.InputStream

@Module
@InstallIn(ViewModelComponent::class)
class PokemonsSerializerModule {
    @Provides
    fun provideSerializer(json: Json): JsonSerializer<List<Pokemon>> =
        object : JsonSerializer<List<Pokemon>> {
            @Suppress("UNCHECKED_CAST")
            override fun <T> decodeFromStream(stream: InputStream): T {
                return json.decodeFromStream<List<Pokemon>>(stream) as T
            }
        }
}