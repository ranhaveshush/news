package com.example.baseapp.ui.preivew

import com.example.baseapp.ui.headlines.state.HeadlineUiState
import com.example.baseapp.ui.pokemons.PokemonItemUiState

object SampleData {
    val headline = HeadlineUiState(
        title = "Robert Bobby Crimo III, Alleged Highland Park Mass Shooter, Left Trail of Red Flags - The Daily Beast",
        urlToImage = "https://img.thedailybeast.com/image/upload/c_crop,d_placeholder_euli9k,h_1688,w_3000,x_0,y_0/dpr_2.0/c_limit,w_740/fl_lossy,q_auto/v1657068991/220705-scouts-shooter-tease-01_miu3d3",
        url = "https://www.thedailybeast.com/robert-bobby-crimo-iii-alleged-highland-park-mass-shooter-left-trail-of-red-flags",
    )

    val pokemonItem = PokemonItemUiState(
        id = 1,
        name = "Bulbasaur",
        imageFileName = String.format("pokemon_%03d", 1)
    )
}