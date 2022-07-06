package com.example.baseapp.ui.common

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.baseapp.ui.theme.AppTheme

@Composable
fun ProgressIndicator() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }
}

@Preview(name = "Light Theme", group = "Progress Indicator")
@Preview(name = "Dark Theme", group = "Progress Indicator", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewProgressIndicator() {
    AppTheme {
        ProgressIndicator()
    }
}
