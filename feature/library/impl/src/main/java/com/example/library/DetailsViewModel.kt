package com.example.library

import androidx.lifecycle.ViewModel
import com.example.database.VideosRepository

class DetailsViewModel(
    val publicId: String,
    repository: VideosRepository,
) : ViewModel() {
    val video = repository.observeVideo(publicId)
}
