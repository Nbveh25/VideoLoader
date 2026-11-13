package com.example.upload.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.ListenableWorker.Result
import androidx.work.WorkerParameters
import com.example.upload.di.UploadComponent
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class UploadWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted params: WorkerParameters,
    private val uploadComponentFactory: UploadComponent.Factory,
) : CoroutineWorker(appContext, params) {

    override suspend fun doWork(): Result {
        val taskId = inputData.getString(KEY_TASK_ID) ?: return Result.failure()
        val session = uploadComponentFactory.create(taskId).session()
        if (session.taskId != taskId) return Result.failure()
        return Result.success()
    }

    @AssistedFactory
    interface Factory {
        fun create(context: Context, params: WorkerParameters): UploadWorker
    }

    private companion object {
        const val KEY_TASK_ID = "taskId"
    }
}
