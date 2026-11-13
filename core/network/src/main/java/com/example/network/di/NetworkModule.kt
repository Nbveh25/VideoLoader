package com.example.network.di

import com.example.network.di.qualifiers.DefaultClient
import com.example.network.di.qualifiers.UploadClient
import dagger.Module
import dagger.Provides
import jakarta.inject.Singleton
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

@Module
object NetworkModule {

    @Provides
    @Singleton
    @DefaultClient
    fun provideDefaultClient() = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

    @Provides
    @Singleton
    @UploadClient
    fun provideUploadClient() = OkHttpClient.Builder()
        .connectTimeout(5, TimeUnit.MINUTES)
        .writeTimeout(5, TimeUnit.MINUTES)
        .callTimeout(10, TimeUnit.MINUTES)
        .build()
}