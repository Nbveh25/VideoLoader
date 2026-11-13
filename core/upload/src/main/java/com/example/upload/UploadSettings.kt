package com.example.upload

import kotlinx.coroutines.flow.Flow

interface UploadSettings {
    val wifiOnly: Flow<Boolean>
    val parallelUploads: Flow<Int>
    suspend fun setWifiOnly(value: Boolean)
    suspend fun setParallelUploads(value: Int)
}
