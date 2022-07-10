package com.example.baseapp.data.news.di

import com.example.baseapp.data.news.NewsRepository
import com.example.baseapp.data.news.NewsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class NewsRepositoryModule {
    @Binds
    abstract fun bindRepository(repository: NewsRepositoryImpl): NewsRepository
}