package io.haider.numbertowordconverter.uidata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import io.haider.numbertowordconverter.appdata.NumberToWordConverterApplication
import io.haider.numbertowordconverter.appdata.UserPreferencesRepository
import io.haider.numbertowordconverter.ui.theme.AppTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ThemeTypeViewModel(
    private val userPreferencesRepository: UserPreferencesRepository

) : ViewModel() {
    private val _themeMode = MutableStateFlow<AppTheme?>(null)
    val themeMode: StateFlow<AppTheme?> = _themeMode.asStateFlow()
//    val themeMode: StateFlow<AppTheme> =
//        userPreferencesRepository.readThemeType.stateIn(
//            scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(5_000),
//            initialValue = AppTheme.MODE_AUTO
//        )

    init {
        viewModelScope.launch {
            userPreferencesRepository.readThemeType.collect { mode ->
                _themeMode.value = mode
            }
        }
    }

    fun selectTheme(appTheme: AppTheme) {
        viewModelScope.launch {
            userPreferencesRepository.saveThemeType(appTheme)
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as NumberToWordConverterApplication)
                ThemeTypeViewModel(application.userPreferencesRepository)
            }
        }
    }

}