package com.example.videoloader

import android.content.Context
import com.example.common.CoroutineProvider
import com.example.upload.di.CloudinaryConfig
import dagger.Module
import dagger.Provides
import jakarta.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
object AppModule {

    @Provides
    @Singleton
    fun provideContext(app: App): Context = app

    @Provides
    @Singleton
    fun provideCloudinaryConfig(): CloudinaryConfig = CloudinaryConfig(
        cloudName = BuildConfig.CLOUDINARY_CLOUD_NAME,
        uploadPreset = BuildConfig.CLOUDINARY_UPLOAD_PRESET
    )

    @Provides
    @Singleton
    fun provideCoroutineProvider(): CoroutineProvider =
        object : CoroutineProvider {
            override fun main(): CoroutineDispatcher =
                Dispatchers.Main

            override fun io(): CoroutineDispatcher =
                Dispatchers.IO

            override fun computation(): CoroutineDispatcher =
                Dispatchers.Default
        }

}