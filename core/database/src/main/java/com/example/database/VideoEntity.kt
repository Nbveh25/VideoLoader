package com.example.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "videos")
data class VideoEntity(
    @PrimaryKey val publicId: String,
    val secureUrl: String,
    val durationMs: Long,
    val title: String,
)
