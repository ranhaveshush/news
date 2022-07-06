package com.example.baseapp.ui.navigation

sealed class Screen(val route: String) {
    object Headlines : Screen("headlines")
    object Article : Screen("article?url={url}") {
        fun createRoute(url: String) = "article?url=$url"
    }
}
