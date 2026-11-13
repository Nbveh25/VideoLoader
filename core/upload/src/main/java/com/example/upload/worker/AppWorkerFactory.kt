package com.example.upload.worker

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class AppWorkerFactory @Inject constructor(
    private val uploadWorkerFactory: UploadWorker.Factory,
) : WorkerFactory() {

    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? = when (workerClassName) {
        UploadWorker::class.java.name -> uploadWorkerFactory.create(
            context = appContext,
            params = workerParameters,
        )

        else -> null
    }


}