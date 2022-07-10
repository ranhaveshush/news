package com.example.baseapp.data.news

import com.example.baseapp.api.news.NewsService
import com.example.baseapp.data.Result
import com.example.baseapp.model.Article
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsService: NewsService,
) : NewsRepository {
    override suspend fun fetchTopHeadlines(
        country: String,
        category: String?,
        pageSize: Int?,
        page: Int?,
    ): Result<List<Article>> {
        val response = newsService.fetchTopHeadlines(
            country = country,
            category = category,
            pageSize = pageSize,
            page = page
        )

        return if (response.isSuccessful()) {
            Result.Success(response.articles)
        } else {
            Result.Error(IllegalArgumentException("Unable to find headlines"))
        }
    }
}