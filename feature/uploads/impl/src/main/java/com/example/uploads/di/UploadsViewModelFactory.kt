package com.example.uploads.di

import com.example.common.viewmodel.VmFactory
import com.example.upload.UploadSettings
import com.example.upload.UploadsRepository
import com.example.uploads.SettingsViewModel
import com.example.uploads.UploadsViewModel
import jakarta.inject.Inject

class UploadsViewModelFactory @Inject constructor(
    private val repository: UploadsRepository,
) : VmFactory {
    override fun create(args: Map<String, Any?>): Any = UploadsViewModel(repository)
}

class SettingsViewModelFactory @Inject constructor(
    private val settings: UploadSettings,
) : VmFactory {
    override fun create(args: Map<String, Any?>): Any = SettingsViewModel(settings)
}
