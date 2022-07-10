package com.example.baseapp.api.news

import com.example.baseapp.BuildConfig
import com.example.baseapp.api.ApiKeyInterceptor
import com.example.baseapp.api.LoggingInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

class NewsApi {
    private val client = OkHttpClient.Builder()
        .addInterceptor(LoggingInterceptor)
        .addInterceptor(
            ApiKeyInterceptor(
                apiKeyName = BuildConfig.API_KEY_NAME,
                apiKeyValue = BuildConfig.API_KEY_VALUE
            )
        )
        .build()

    private val retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(BuildConfig.NEWS_URL)
//        .addConverterFactory(MoshiConverterFactory.create())
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .build()

    val service: NewsService = retrofit.create(NewsService::class.java)
}
