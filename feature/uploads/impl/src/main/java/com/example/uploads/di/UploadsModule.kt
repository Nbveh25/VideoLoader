package com.example.uploads.di

import androidx.lifecycle.ViewModelProvider
import com.example.common.viewmodel.ViewModelKey
import com.example.common.viewmodel.VmFactory
import com.example.uploads.SettingsViewModel
import com.example.uploads.UploadsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface UploadsModule {

    @Binds
    @IntoMap
    @ViewModelKey(UploadsViewModel::class)
    fun bindUploads(factory: UploadsViewModelFactory): VmFactory

    @Binds
    @IntoMap
    @ViewModelKey(SettingsViewModel::class)
    fun bindSettings(factory: SettingsViewModelFactory): VmFactory

    @Binds
    fun bindFactory(factory: MultiboundViewModelFactory): ViewModelProvider.Factory
}
