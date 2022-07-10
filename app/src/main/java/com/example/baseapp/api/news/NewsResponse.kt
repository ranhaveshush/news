package com.example.baseapp.api.news

import com.example.baseapp.model.Article
import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
) {
    fun isSuccessful(): Boolean = status == "ok"
}