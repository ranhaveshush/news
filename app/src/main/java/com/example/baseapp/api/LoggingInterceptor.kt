package com.example.baseapp.api

import com.example.baseapp.BuildConfig
import okhttp3.logging.HttpLoggingInterceptor

val LoggingInterceptor
    get() = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }