package com.example.examatetask.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Extension property to create a DataStore instance
private val Context.dataStore by preferencesDataStore(name = "settings")

class DataStoreManager(context: Context) {

    // Reference to the DataStore instance
    private val dataStore = context.dataStore

    companion object {
        // Key to store the tutorial shown flag
        val TUTORIAL_SHOWN_KEY = booleanPreferencesKey("tutorial_shown")
    }

    // Flow to observe the tutorial shown flag
    val tutorialShown: Flow<Boolean> = dataStore.data
        .map { preferences ->
            // Return the value of the tutorial shown flag, defaulting to false if not set
            preferences[TUTORIAL_SHOWN_KEY] ?: false
        }

    // Function to update the tutorial shown flag
    suspend fun setTutorialShown(shown: Boolean) {
        dataStore.edit { preferences ->
            // Set the value of the tutorial shown flag
            preferences[TUTORIAL_SHOWN_KEY] = shown
        }
    }
}