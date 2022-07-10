package com.example.baseapp.ui.common

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

@DrawableRes
@Composable
fun drawableResource(drawableFileName: String): Int {
    val context = LocalContext.current
    return remember(drawableFileName) {
        context.resources.getIdentifier(drawableFileName, "drawable", context.packageName)
    }
}
