package com.example.videoloader

import com.example.database.di.DatabaseModule
import com.example.database.di.VideosRepositoryModule
import com.example.library.di.LibraryComponent
import com.example.library.di.LibraryComponentModule
import com.example.network.di.NetworkModule
import com.example.upload.di.UploadModule
import com.example.upload.di.UploadSettingsModule
import com.example.upload.worker.AppWorkerFactory
import com.example.uploads.di.UploadsComponent
import com.example.uploads.di.UploadsComponentModule
import dagger.BindsInstance
import dagger.Component
import jakarta.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        UploadSettingsModule::class,
        UploadModule::class,
        VideosRepositoryModule::class,
        LibraryComponentModule::class,
        UploadsComponentModule::class,
    ],
)
interface AppComponent {

    fun workerFactory(): AppWorkerFactory

    fun libraryComponentFactory(): LibraryComponent.Factory

    fun uploadsComponentFactory(): UploadsComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: App): AppComponent
    }
}
