package com.example.library.di

import androidx.lifecycle.ViewModelProvider
import com.example.common.di.FeatureScope
import dagger.Subcomponent

@FeatureScope
@Subcomponent(modules = [LibraryModule::class])
interface LibraryComponent {
    fun viewModelFactory(): ViewModelProvider.Factory

    @Subcomponent.Factory
    interface Factory {
        fun create(): LibraryComponent
    }
}
