package com.example.baseapp.ui.headlines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.baseapp.data.Result
import com.example.baseapp.data.news.NewsRepository
import com.example.baseapp.ui.common.ErrorMessage
import com.example.baseapp.ui.headlines.state.HeadlinesUiState
import com.example.baseapp.ui.headlines.transfomer.HeadlineUiStateTransformer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeadlinesViewModel @Inject constructor(
    private val repository: NewsRepository,
    private val transformer: HeadlineUiStateTransformer,
) : ViewModel() {
    private val _uiState = MutableStateFlow(HeadlinesUiState(isLoading = true))
    val uiState: StateFlow<HeadlinesUiState> = _uiState.asStateFlow()

    init {
        load()
    }

    private fun load() {
        viewModelScope.launch {
            _uiState.value = HeadlinesUiState(isLoading = true)

            _uiState.value = when (val result = repository.fetchTopHeadlines(country = "us")) {
                is Result.Success -> HeadlinesUiState(
                    headlines = transformer.transform(result.data)
                )
                else -> HeadlinesUiState(
                    errorMessages = listOf(ErrorMessage("Unable to fetch headlines"))
                )
            }
        }
    }
}