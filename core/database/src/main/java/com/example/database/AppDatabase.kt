package com.example.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [UploadTaskEntity::class, VideoEntity::class],
    version = 1,
    exportSchema = false,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun uploadTaskDao(): UploadTaskDao
    abstract fun videoDao(): VideoDao
}
