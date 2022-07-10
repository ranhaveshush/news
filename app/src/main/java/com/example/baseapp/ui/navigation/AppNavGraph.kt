package com.example.baseapp.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.baseapp.ui.article.ArticleRoute
import com.example.baseapp.ui.headlines.HeadlinesRoute
import com.example.baseapp.ui.pokemonDetails.PokemonDetailsRoute
import com.example.baseapp.ui.pokemons.PokemonsRoute
import com.google.accompanist.navigation.material.BottomSheetNavigator
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalComposeUiApi
@ExperimentalMotionApi
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@ExperimentalMaterialNavigationApi
@ExperimentalPagerApi
@Composable
fun AppNavGraph(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    bottomSheetNavigator: BottomSheetNavigator = rememberBottomSheetNavigator(),
    navController: NavHostController = rememberNavController(bottomSheetNavigator),
    startDestination: String = Screen.Headlines.route
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            AppBottomBar(
                navBackStackEntry = navBackStackEntry,
                onNavigationItemClick = { route ->
                    navController.navigate(route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    ) { innerPadding ->
        ModalBottomSheetLayout(bottomSheetNavigator) {
            NavHost(navController, startDestination) {
                composable(route = Screen.Headlines.route) {
                    HeadlinesRoute(
                        onHeadlineClick = { headline ->
                            navController.navigate(Screen.Article.createRoute(headline.url))
                        }
                    )
                }
                composable(
                    route = Screen.Article.route,
                    arguments = listOf(navArgument("url") { type = NavType.StringType })
                ) { navBackStackEntry ->
                    val url = navBackStackEntry.arguments?.getString("url") ?: ""

                    ArticleRoute(
                        url = url

                    )
                }
                composable(route = Screen.Pokemons.route) {
                    PokemonsRoute(
                        onPokemonItemClick = { pokemonId ->
                            navController.navigate(Screen.PokemonDetails.createRoute(pokemonId))
                        }
                    )
                }
                composable(route = Screen.PokemonDetails.route) { navBackStackEntry ->
                    val pokemonIdArg = navBackStackEntry.arguments?.getString("pokemonId") ?: "1"
                    val pokemonId = pokemonIdArg.toInt()

                    PokemonDetailsRoute(
                        pokemonId = pokemonId
                    )
                }
            }
        }
    }
}
