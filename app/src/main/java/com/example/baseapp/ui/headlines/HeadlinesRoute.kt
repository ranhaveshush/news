package com.example.baseapp.ui.headlines

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.baseapp.ui.headlines.state.HeadlineUiState
import com.example.baseapp.ui.theme.AppTheme

@Composable
fun HeadlinesRoute(
    onHeadlineClick: (HeadlineUiState) -> Unit,
    viewModel: HeadlinesViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold {
        LazyColumn(
            contentPadding = PaddingValues(AppTheme.padding.medium),
            modifier = Modifier.fillMaxSize()
        ) {
            items(uiState.headlines) { item ->
                HeadlineItem(
                    uiState = item,
                    onHeadlineClick = onHeadlineClick
                )
                Spacer(modifier = Modifier.height(AppTheme.padding.medium))
            }
        }
    }
}