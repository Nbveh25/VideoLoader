package com.example.upload.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import com.example.upload.UploadSettings
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreUploadSettings @Inject constructor(
    private val dataStore: DataStore<Preferences>,
) : UploadSettings {

    override val wifiOnly: Flow<Boolean> = dataStore.data.map { prefs ->
        prefs[WIFI_ONLY] ?: false
    }

    override val parallelUploads: Flow<Int> = dataStore.data.map { prefs ->
        prefs[PARALLEL] ?: 1
    }

    override suspend fun setWifiOnly(value: Boolean) {
        dataStore.edit { prefs -> prefs[WIFI_ONLY] = value }
    }

    override suspend fun setParallelUploads(value: Int) {
        dataStore.edit { prefs -> prefs[PARALLEL] = value.coerceIn(1, 3) }
    }

    private companion object {
        val WIFI_ONLY = booleanPreferencesKey("wifi_only")
        val PARALLEL = intPreferencesKey("parallel_uploads")
    }
}
