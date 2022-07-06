package com.example.baseapp.ui.headlines.state

import com.example.baseapp.ui.common.ErrorMessage

data class HeadlinesUiState(
    val isLoading: Boolean = false,
    val headlines: List<HeadlineUiState> = emptyList(),
    val errorMessages: List<ErrorMessage> = emptyList(),
    val searchInput: String = "",
)