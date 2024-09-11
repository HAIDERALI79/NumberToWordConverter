package io.haider.numbertowordconverter.appdata

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

private const val THEME_PREFERENCE_NAME = "theme_preference"
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = THEME_PREFERENCE_NAME)

class NumberToWordConverterApplication : Application() {
    lateinit var userPreferencesRepository: UserPreferencesRepository

    override fun onCreate() {
        super.onCreate()
        userPreferencesRepository = UserPreferencesRepository(dataStore = dataStore)
    }
}