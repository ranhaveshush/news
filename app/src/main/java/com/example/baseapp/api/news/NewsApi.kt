package com.example.baseapp.api.news

import com.example.baseapp.BuildConfig
import com.example.baseapp.api.ApiKeyInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NewsApi {
    private val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        })
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
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val service: NewsService = retrofit.create(NewsService::class.java)
}