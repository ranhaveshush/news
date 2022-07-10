package com.example.baseapp.ui.pokemonDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.baseapp.data.pokemons.PokemonsRepository
import com.example.baseapp.ui.pokemonDetails.transformer.PokemonDetailsUiStateTransformer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val repository: PokemonsRepository,
    private val transformer: PokemonDetailsUiStateTransformer,
) : ViewModel() {
    fun pokemonDetails(pokemonId: Int): StateFlow<PokemonDetailsUiState> = flow {
        val pokemonDetails = repository.getPokemon(pokemonId)
        val uiState = transformer.transform(pokemonDetails)
        emit(uiState)
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        PokemonDetailsUiState(isLoading = true)
    )
}