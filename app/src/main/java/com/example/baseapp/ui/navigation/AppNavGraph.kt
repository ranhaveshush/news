package com.example.baseapp.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.plusAssign
import com.example.baseapp.ui.article.ArticleRoute
import com.example.baseapp.ui.headlines.HeadlinesRoute
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
    bottomSheetNavigator: BottomSheetNavigator = rememberBottomSheetNavigator(),
    navController: NavHostController = rememberNavController(bottomSheetNavigator),
    startDestination: String = Screen.Headlines.route
) {
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
                arguments = listOf(navArgument("url") { defaultValue = "" })
            ) { navBackStackEntry ->
                val url = navBackStackEntry.arguments?.getString("url") ?: ""

                ArticleRoute(
                    url = url
                )
            }
        }
    }
}
