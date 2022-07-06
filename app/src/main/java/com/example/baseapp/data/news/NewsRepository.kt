package com.example.baseapp.data.news

import com.example.baseapp.model.Article
import com.example.baseapp.data.Result

interface NewsRepository {
    suspend fun fetchTopHeadlines(
        country: String,
        category: String? = null,
        pageSize: Int? = null,
        page: Int? = null,
    ): Result<List<Article>>
}