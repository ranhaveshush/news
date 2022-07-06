package com.example.baseapp.api.news

import com.example.baseapp.model.Article

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)