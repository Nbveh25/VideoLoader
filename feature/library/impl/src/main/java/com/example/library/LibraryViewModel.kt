package com.example.library

import androidx.lifecycle.ViewModel
import com.example.database.VideosRepository

class LibraryViewModel(
    repository: VideosRepository,
) : ViewModel() {
    val videos = repository.observeVideos()
}
