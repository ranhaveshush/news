package com.example.baseapp.ui.headlines.di

import com.example.baseapp.ui.headlines.transfomer.HeadlineUiStateTransformer
import com.example.baseapp.ui.headlines.transfomer.HeadlinesUiStateTransformerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class HeadlineUiStat1eTransformerModule {
    @Binds
    abstract fun bindTransformer(transformer: HeadlinesUiStateTransformerImpl): HeadlineUiStateTransformer
}