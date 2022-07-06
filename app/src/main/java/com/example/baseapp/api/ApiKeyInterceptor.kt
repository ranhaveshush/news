package com.example.baseapp.api

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class ApiKeyInterceptor(
    private val apiKeyName: String,
    private val apiKeyValue: String
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newUrl = "${request.url}&$apiKeyName=$apiKeyValue"

        val newRequest = Request.Builder()
            .url(newUrl)
            .build()

        return chain.proceed(newRequest)
    }
}