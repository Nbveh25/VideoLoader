package com.example.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "upload_tasks")
data class UploadTaskEntity(
    @PrimaryKey val id: String,
    val status: String,
    val bytesUploaded: Long,
    val totalBytes: Long,
)
