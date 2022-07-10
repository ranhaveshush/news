package com.example.baseapp.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val screen: Screen,
    val icon: ImageVector,
    @StringRes val label: Int,
)