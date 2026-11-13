package com.example.uploads

import androidx.lifecycle.ViewModel
import com.example.upload.UploadSettings

class SettingsViewModel(
    settings: UploadSettings,
) : ViewModel() {
    val wifiOnly = settings.wifiOnly
    val parallelUploads = settings.parallelUploads
}
