package com.example.videoloader

import android.content.Context
import com.example.library.di.LibraryComponent
import com.example.uploads.di.UploadsComponent

fun Context.libraryComponent(): LibraryComponent =
    (applicationContext as App).libraryComponent

fun Context.uploadsComponent(): UploadsComponent =
    (applicationContext as App).uploadsComponent
