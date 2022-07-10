package com.example.baseapp.ui.pokemons

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.baseapp.data.Result
import com.example.baseapp.data.pokemons.PokemonsRepository
import com.example.baseapp.ui.pokemons.transformer.PokemonItemUiStateTransformer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class PokemonsViewModel @Inject constructor(
    private val repository: PokemonsRepository,
    private val transformer: PokemonItemUiStateTransformer,
) : ViewModel() {
    val uiState: StateFlow<PokemonsUiState> = flow {
        val result = repository.listPokemons()
        // TODO: handle error result.
        if (result !is Result.Success) return@flow
        val pokemons = result.data
        val uiState = PokemonsUiState(pokemons = transformer.transform(pokemons))
        emit(uiState)
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        PokemonsUiState(isLoading = true)
    )
}