package com.example.library.di

import androidx.lifecycle.ViewModelProvider
import com.example.common.viewmodel.ViewModelKey
import com.example.common.viewmodel.VmFactory
import com.example.library.DetailsViewModel
import com.example.library.LibraryViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface LibraryModule {
    @Binds
    @IntoMap
    @ViewModelKey(LibraryViewModel::class)
    fun bindLibrary(factory: LibraryViewModelFactory): VmFactory

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    fun bindDetails(factory: DetailsViewModelFactory): VmFactory

    @Binds
    fun bindFactory(factory: MultiboundViewModelFactory): ViewModelProvider.Factory
}
