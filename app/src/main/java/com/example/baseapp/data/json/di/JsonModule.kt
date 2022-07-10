package com.example.baseapp.data.json.di

import com.example.baseapp.data.json.format
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class JsonModule {
    @Singleton
    @Provides
    fun provideJson(): Json = format
}