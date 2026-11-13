package com.example.upload.di

import com.example.network.di.qualifiers.UploadClient
import com.example.upload.di.qualifier.TaskId
import jakarta.inject.Inject
import okhttp3.OkHttpClient

@UploadScope
class UploadSession @Inject constructor(
    @TaskId val taskId: String,
    @UploadClient private val client: OkHttpClient,
    private val config: CloudinaryConfig,
) {

    fun uploadUrl(): String =
        "https://api.cloudinary.com/v1_1/${config.cloudName}/video/upload"

    fun callTimeoutMillis(): Int = client.callTimeoutMillis
}
