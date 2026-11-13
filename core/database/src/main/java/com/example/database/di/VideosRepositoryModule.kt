package com.example.database.di

import com.example.database.VideosRepository
import com.example.database.VideosRepositoryImpl
import dagger.Binds
import dagger.Module
import jakarta.inject.Singleton

@Module
interface VideosRepositoryModule {
    @Binds
    @Singleton
    fun bindVideosRepository(impl: VideosRepositoryImpl): VideosRepository
}
