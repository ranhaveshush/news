package com.example.baseapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

private val LightColors = lightColors(
    primary = md_theme_light_primary,
    primaryVariant = md_theme_light_primaryContainer,
    secondary = md_theme_light_secondary,
    secondaryVariant = md_theme_light_secondaryContainer,
    background = md_theme_light_background,
    surface = md_theme_light_surface,
    error = md_theme_light_error,
    onPrimary = md_theme_light_onPrimary,
    onSecondary = md_theme_light_onSecondary,
    onBackground = md_theme_light_onBackground,
    onSurface = md_theme_light_onSurface,
    onError = md_theme_light_onError
)

private val DarkColors = darkColors(
    primary = md_theme_dark_primary,
    primaryVariant = md_theme_dark_primaryContainer,
    secondary = md_theme_dark_secondary,
    secondaryVariant = md_theme_dark_secondaryContainer,
    background = md_theme_dark_background,
    surface = md_theme_dark_surface,
    error = md_theme_dark_error,
    onPrimary = md_theme_dark_onPrimary,
    onSecondary = md_theme_dark_onSecondary,
    onBackground = md_theme_dark_onBackground,
    onSurface = md_theme_dark_onSurface,
    onError = md_theme_dark_onError
)

@Composable
fun AppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalPadding provides AppTheme.padding,
        LocalMargin provides AppTheme.margin
    ) {
        MaterialTheme(
            colors = if (darkTheme) DarkColors else LightColors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

object AppTheme {
    val colors: Colors
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colors

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.typography

    val shapes: Shapes
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.shapes

    val padding: Padding
        @Composable
        @ReadOnlyComposable
        get() = LocalPadding.current

    val margin: Margin
        @Composable
        @ReadOnlyComposable
        get() = LocalMargin.current
}

internal val LocalPadding = staticCompositionLocalOf { Padding() }
internal val LocalMargin = staticCompositionLocalOf { Margin() }
