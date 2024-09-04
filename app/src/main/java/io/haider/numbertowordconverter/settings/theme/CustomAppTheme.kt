package io.haider.numbertowordconverter.settings.theme

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import io.haider.numbertowordconverter.ui.theme.AppTheme
import io.haider.numbertowordconverter.ui.theme.LocalTheme
import io.haider.numbertowordconverter.ui.theme.NumberToWordConverterTheme

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun UserAppTheme(
    appTheme: AppTheme,
    content: @Composable () -> Unit
) {
    val isDarkTheme = when (appTheme) {
        AppTheme.MODE_DAY -> false
        AppTheme.MODE_NIGHT -> true
        AppTheme.MODE_AUTO -> isSystemInDarkTheme()
    }
    //val context = LocalContext.current
    NumberToWordConverterTheme(
        darkTheme = isDarkTheme,
        dynamicColor = true
    ) {
        CompositionLocalProvider(LocalTheme provides appTheme) {
            content()
        }
    }

}