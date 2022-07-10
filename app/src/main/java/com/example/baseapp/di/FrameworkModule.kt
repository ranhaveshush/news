package com.example.baseapp.di

import android.content.Context
import android.content.pm.PackageManager
import android.content.res.AssetManager
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class FrameworkModule {
    @Provides
    fun provideContext(
        @ApplicationContext context: Context,
    ): Context = context

    @Provides
    fun providePackageManager(
        @ApplicationContext context: Context,
    ): PackageManager = context.packageManager

    @Provides
    fun provideAssetManager(
        @ApplicationContext context: Context,
    ): AssetManager = context.assets

    @Provides
    fun provideResources(
        @ApplicationContext context: Context,
    ): Resources = context.resources
}
