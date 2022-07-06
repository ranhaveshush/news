package com.example.baseapp.ui.headlines.transfomer

import com.example.baseapp.model.Article
import com.example.baseapp.ui.headlines.state.HeadlineUiState
import javax.inject.Inject

class HeadlinesUiStateTransformerImpl @Inject constructor() : HeadlineUiStateTransformer {
    override fun transform(data: Article): HeadlineUiState = HeadlineUiState(
        title = data.title,
        urlToImage = data.urlToImage,
        url = data.url
    )
}