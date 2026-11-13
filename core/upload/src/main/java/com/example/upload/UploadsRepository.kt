package com.example.upload

import kotlinx.coroutines.flow.Flow

data class UploadTask(
    val id: String,
    val status: String,
    val bytesUploaded: Long,
    val totalBytes: Long,
)

interface UploadsRepository {
    fun observeTasks(): Flow<List<UploadTask>>
}
