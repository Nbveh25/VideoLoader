package com.example.library.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.common.viewmodel.VmFactory
import jakarta.inject.Inject
import jakarta.inject.Provider

class MultiboundViewModelFactory @Inject constructor(
    private val factories: Map<Class<*>, @JvmSuppressWildcards Provider<VmFactory>>,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        val creator = factories[modelClass]?.get()
            ?: throw IllegalArgumentException("Нет фабрики для $modelClass")
        val handle = extras.createSavedStateHandle()
        val args = handle.keys().associateWith { key -> handle.get<Any?>(key) }
        @Suppress("UNCHECKED_CAST")
        return creator.create(args) as T
    }
}
