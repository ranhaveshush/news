package com.example.baseapp.data.pokemons

import com.example.baseapp.data.file.FileDataSource
import com.example.baseapp.model.Pokemon

interface PokemonsLocalDataSource : FileDataSource<Pokemon>