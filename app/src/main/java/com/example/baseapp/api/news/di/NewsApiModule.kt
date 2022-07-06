package com.example.baseapp.api.news.di

import com.example.baseapp.api.news.NewsApi
import com.example.baseapp.api.news.NewsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class NewsApiModule {
    @Provides
    fun providesApi(): NewsApi = NewsApi

    @Provides
    fun providesService(api: NewsApi): NewsService = NewsApi.service
}