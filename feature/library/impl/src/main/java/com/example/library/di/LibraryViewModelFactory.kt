package com.example.library.di

import com.example.common.viewmodel.VmFactory
import com.example.database.VideosRepository
import com.example.library.DetailsViewModel
import com.example.library.LibraryViewModel
import jakarta.inject.Inject

class LibraryViewModelFactory @Inject constructor(
    private val repository: VideosRepository,
) : VmFactory {
    override fun create(args: Map<String, Any?>): Any = LibraryViewModel(repository)
}

class DetailsViewModelFactory @Inject constructor(
    private val repository: VideosRepository,
) : VmFactory {
    override fun create(args: Map<String, Any?>): Any = DetailsViewModel(
        publicId = args[PUBLIC_ID] as? String ?: error("publicId"),
        repository = repository,
    )

    companion object {
        const val PUBLIC_ID = "publicId"
    }
}
