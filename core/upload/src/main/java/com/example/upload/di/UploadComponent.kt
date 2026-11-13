package com.example.upload.di

import com.example.upload.di.qualifier.TaskId
import dagger.BindsInstance
import dagger.Subcomponent

@UploadScope
@Subcomponent
interface UploadComponent {

    fun session(): UploadSession

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance @TaskId taskId: String): UploadComponent
    }
}
