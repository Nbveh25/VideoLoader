package com.example.database

import kotlinx.coroutines.flow.Flow

data class VideoRecord(
    val publicId: String,
    val secureUrl: String,
    val durationMs: Long,
    val title: String,
)

interface VideosRepository {
    fun observeVideos(): Flow<List<VideoRecord>>
    fun observeVideo(publicId: String): Flow<VideoRecord?>
}
