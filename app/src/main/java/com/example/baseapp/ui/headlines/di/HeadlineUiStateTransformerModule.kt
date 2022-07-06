package com.example.baseapp.ui.headlines.di

import com.example.baseapp.ui.headlines.transfomer.HeadlineUiStateTransformer
import com.example.baseapp.ui.headlines.transfomer.HeadlinesUiStateTransformerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class HeadlineUiStateTransformerModule {
    @Binds
    abstract fun bindTransformer(transformer: HeadlinesUiStateTransformerImpl): HeadlineUiStateTransformer
}