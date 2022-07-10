package com.example.baseapp.ui.headlines.transfomer

import com.example.baseapp.model.Article
import com.example.baseapp.ui.common.UiStateTransformer
import com.example.baseapp.ui.headlines.state.HeadlineUiState

interface HeadlineUiStateTransformer : UiStateTransformer<Article, HeadlineUiState>