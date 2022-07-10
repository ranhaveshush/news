package com.example.baseapp.ui.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hierarchy
import com.example.baseapp.R

@Composable
fun AppBottomBar(
    navBackStackEntry: NavBackStackEntry?,
    onNavigationItemClick: (route: String) -> Unit
) {
    val currentDestination = navBackStackEntry?.destination

    val items = bottomNavigationItems()

    BottomNavigation {
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = stringResource(id = item.label)
                    )
                },
                label = { Text(text = stringResource(id = item.label)) },
                selected = currentDestination?.hierarchy?.any { it.route == item.screen.route } == true,
                onClick = {
                    onNavigationItemClick(item.screen.route)
                }
            )
        }
    }
}

private fun bottomNavigationItems() = listOf(
    NavigationItem(
        screen = Screen.Headlines,
        icon = Icons.Rounded.Home,
        label = R.string.headlines_title
    ),
    NavigationItem(
        screen = Screen.Pokemons,
        icon = Icons.Rounded.Face,
        label = R.string.pokemons_title
    ),
)