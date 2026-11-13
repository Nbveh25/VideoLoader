package com.example.database.di

import android.content.Context
import androidx.room.Room
import com.example.database.AppDatabase
import com.example.database.UploadTaskDao
import com.example.database.VideoDao
import dagger.Module
import dagger.Provides
import jakarta.inject.Singleton

@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app.db",
        ).build()

    @Provides
    @Singleton
    fun provideUploadTaskDao(db: AppDatabase): UploadTaskDao = db.uploadTaskDao()

    @Provides
    @Singleton
    fun provideVideoDao(db: AppDatabase): VideoDao = db.videoDao()
}
