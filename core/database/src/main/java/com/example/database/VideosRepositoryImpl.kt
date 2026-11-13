package com.example.database

import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class VideosRepositoryImpl @Inject constructor(
    private val dao: VideoDao,
) : VideosRepository {
    override fun observeVideos(): Flow<List<VideoRecord>> =
        dao.observeAll().map { videos -> videos.map { it.toRecord() } }

    override fun observeVideo(publicId: String): Flow<VideoRecord?> =
        dao.observeById(publicId).map { video -> video?.toRecord() }
}

private fun VideoEntity.toRecord() = VideoRecord(
    publicId = publicId,
    secureUrl = secureUrl,
    durationMs = durationMs,
    title = title,
)
