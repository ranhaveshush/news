package com.example.baseapp.ui.pokemonDetails

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.baseapp.R
import com.example.baseapp.ui.common.drawableResource
import com.example.baseapp.ui.theme.AppTheme

@Composable
fun PokemonDetailsRoute(
    pokemonId: Int,
    viewModel: PokemonDetailsViewModel = hiltViewModel()
) {
    val uiState by viewModel.pokemonDetails(pokemonId).collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(AppTheme.padding.medium)
    ) {
        Spacer(modifier = Modifier.height(AppTheme.padding.xLarge))

        val drawableRes = drawableResource(drawableFileName = uiState.imageFileName)
        AsyncImage(
            model = drawableRes,
            contentDescription = stringResource(id = R.string.content_description_pokemon_item_image),
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.height(AppTheme.padding.medium))
        Text(
            text = uiState.name,
            style = AppTheme.typography.h5,
        )
        Spacer(modifier = Modifier.height(AppTheme.padding.medium))
        Text(
            text = uiState.description,
            style = AppTheme.typography.body1,
            modifier = Modifier.padding(AppTheme.padding.xLarge)
        )
    }
}

@Preview(name = "Light Theme", group = "Pokemon Details")
@Preview(name = "Dark Theme", group = "Pokemon Details", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewPokemonDetails() {
    AppTheme {
        PokemonDetailsRoute(pokemonId = 1)
    }
}