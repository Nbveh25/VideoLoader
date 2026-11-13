package com.example.videoloader

import android.app.Application
import androidx.work.Configuration
import com.example.library.di.LibraryComponent
import com.example.uploads.di.UploadsComponent

class App : Application(), Configuration.Provider {

    lateinit var appComponent: AppComponent

    val libraryComponent: LibraryComponent by lazy {
        appComponent.libraryComponentFactory().create()
    }

    val uploadsComponent: UploadsComponent by lazy {
        appComponent.uploadsComponentFactory().create()
    }

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setWorkerFactory(appComponent.workerFactory())
            .build()

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }
}
