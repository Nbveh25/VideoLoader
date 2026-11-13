package com.example.uploads.di

import androidx.lifecycle.ViewModelProvider
import com.example.common.di.FeatureScope
import dagger.Subcomponent

@FeatureScope
@Subcomponent(modules = [UploadsModule::class])
interface UploadsComponent {

    fun viewModelFactory(): ViewModelProvider.Factory

    @Subcomponent.Factory
    interface Factory {
        fun create(): UploadsComponent
    }
}
