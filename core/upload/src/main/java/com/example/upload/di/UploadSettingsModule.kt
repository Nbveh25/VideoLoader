package com.example.upload.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.Provides
import jakarta.inject.Singleton

@Module
object UploadSettingsModule {

    private val Context.dataStore by preferencesDataStore("upload_settings")

    @Provides
    @Singleton
    fun provideDataStore(context: Context): DataStore<Preferences> =
        context.dataStore
}