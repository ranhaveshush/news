package com.example.baseapp.api.news

import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("top-headlines")
    suspend fun fetchTopHeadlines(
        @Query("country") country: String,
        @Query("category") category: String? = null,
        @Query("pageSize") pageSize: Int? = null,
        @Query("page") page: Int? = null,
    ): NewsResponse
}