package com.example.database

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UploadTaskDao {
    @Query("SELECT * FROM upload_tasks")
    fun observeAll(): Flow<List<UploadTaskEntity>>
}
