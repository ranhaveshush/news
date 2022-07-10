package com.example.baseapp.ui.pokemons

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.example.baseapp.R
import com.example.baseapp.ui.common.drawableResource
import com.example.baseapp.ui.preivew.SampleData
import com.example.baseapp.ui.theme.AppTheme

@Composable
fun PokemonItem(
    uiState: PokemonItemUiState,
    onPokemonItemClick: (Int) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = AppTheme.padding.small)
            .clip(AppTheme.shapes.small)
            .clickable {
                onPokemonItemClick(uiState.id)
            }
            .padding(AppTheme.padding.medium)
    ) {
        val drawableResource = drawableResource(drawableFileName = uiState.imageFileName)

        AsyncImage(
            model = drawableResource,
            contentDescription = stringResource(id = R.string.content_description_pokemon_item_image)
        )
        Spacer(modifier = Modifier.width(AppTheme.padding.medium))
        Text(
            text = uiState.name,
            style = AppTheme.typography.h6,
        )
    }
}

@Preview(name = "Light Theme", group = "Pokemon Item")
@Preview(name = "Dark Theme", group = "Pokemon Item", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewPokemonItem() {
    AppTheme {
        PokemonItem(
            uiState = SampleData.pokemonItem,
            onPokemonItemClick = {}
        )
    }
}

