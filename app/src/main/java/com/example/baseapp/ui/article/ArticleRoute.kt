package com.example.baseapp.ui.article

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState

@Composable
fun ArticleRoute(
    url: String,
) {
    val state = rememberWebViewState(url = url)

    WebView(
        state = state,
        modifier = Modifier.fillMaxSize()
    )
}