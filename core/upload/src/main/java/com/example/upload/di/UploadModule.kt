package com.example.upload.di

import com.example.upload.UploadSettings
import com.example.upload.UploadsRepository
import dagger.Binds
import dagger.Module
import jakarta.inject.Singleton

@Module(subcomponents = [UploadComponent::class])
interface UploadModule {

    @Binds
    @Singleton
    fun bindUploadsRepository(impl: UploadsRepositoryImpl): UploadsRepository

    @Binds
    @Singleton
    fun bindUploadSettings(impl: DataStoreUploadSettings): UploadSettings
}
