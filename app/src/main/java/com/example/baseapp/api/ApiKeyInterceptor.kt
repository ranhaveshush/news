package com.example.baseapp.api

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class ApiKeyInterceptor(
    private val apiKeyName: String,
    private val apiKeyValue: String,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url

        val newUrl = originalUrl.newBuilder()
            .addQueryParameter(apiKeyName, apiKeyValue)
            .build()

        val newRequest = Request.Builder()
            .url(newUrl)
            .build()

        return chain.proceed(newRequest)
    }
}