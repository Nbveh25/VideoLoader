package com.example.upload.di

import com.example.database.UploadTaskDao
import com.example.upload.UploadTask
import com.example.upload.UploadsRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UploadsRepositoryImpl @Inject constructor(
    private val dao: UploadTaskDao,
) : UploadsRepository {

    override fun observeTasks(): Flow<List<UploadTask>> =
        dao.observeAll().map { tasks ->
            tasks.map { task ->
                UploadTask(
                    id = task.id,
                    status = task.status,
                    bytesUploaded = task.bytesUploaded,
                    totalBytes = task.totalBytes,
                )
            }
        }
}
