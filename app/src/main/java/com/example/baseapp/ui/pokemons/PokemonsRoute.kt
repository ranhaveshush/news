package com.example.baseapp.ui.pokemons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.baseapp.ui.theme.AppTheme

@Composable
fun PokemonsRoute(
    onPokemonItemClick: (Int) -> Unit,
    viewModel: PokemonsViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    LazyColumn(
        contentPadding = PaddingValues(vertical = AppTheme.padding.small),
        modifier = Modifier.fillMaxSize()
    ) {
        items(
            items = uiState.pokemons,
            key = { item -> item.id }
        ) { item ->
            PokemonItem(
                uiState = item,
                onPokemonItemClick = onPokemonItemClick
            )
        }
    }
}