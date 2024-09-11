package io.haider.numbertowordconverter.appdata

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import io.haider.numbertowordconverter.ui.theme.AppTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class UserPreferencesRepository(
    private val dataStore: DataStore<Preferences>
) {
    private companion object {
        val THEME_TYPE = stringPreferencesKey("theme_type")
        const val TAG = "userPreferenceRepo"
    }

    suspend fun saveThemeType(themeType: AppTheme) {
        dataStore.edit { preferences ->
            preferences[THEME_TYPE] = themeType.name
        }
    }

    val readThemeType: Flow<AppTheme> = dataStore.data.catch {
        if (it is IOException) {
            Log.e(TAG, "there is error in reading preferences", it)
        } else throw it
    }.map { preferences ->
        AppTheme.valueOf(preferences[THEME_TYPE] ?: AppTheme.MODE_AUTO.name)

    }
//        dataStore.data.catch {
//        if (it is IOException) {
//            Log.e(TAG, "there is error in reading preferences", it)
//        } else throw it
//    }.map { preferences ->
//        preferences[THEME_TYPE] ?: " "
//
//    }
}

//val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
//val themeKey = stringPreferencesKey("theme")
//
//
//fun readData(context: Context) =
//    context.dataStore.data
//        .map { preferences ->
//            preferences[themeKey] ?: " "
//        }


//suspend fun writeData(context: Context, theme: String) {
//    context.dataStore.edit { settings ->
//        //   theme = settings[themeKey] ?: " "
//        settings[themeKey] = theme
//    }
//}

//@Composable
//fun ReadThemeData() {
//    val context = LocalContext.current
//    val sampleData = runBlocking { context.dataStore.data.first() }
//}