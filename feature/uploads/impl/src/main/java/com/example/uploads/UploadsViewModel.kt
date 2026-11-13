package com.example.uploads

import androidx.lifecycle.ViewModel
import com.example.upload.UploadsRepository

class UploadsViewModel(
    repository: UploadsRepository,
) : ViewModel() {
    val tasks = repository.observeTasks()
}
