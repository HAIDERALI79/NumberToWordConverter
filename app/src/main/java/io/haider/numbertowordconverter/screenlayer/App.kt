package io.haider.numbertowordconverter.screenlayer

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.haider.numbertowordconverter.R
import io.haider.numbertowordconverter.settings.Settings
import io.haider.numbertowordconverter.ui.theme.AppTheme
import io.haider.numbertowordconverter.ui.theme.NumberToWordConverterTheme
import io.haider.numbertowordconverter.uidata.ThemeTypeViewModel

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun App(
    modifier: Modifier = Modifier,
    themeTypeViewModel: ThemeTypeViewModel = viewModel(
        factory = ThemeTypeViewModel.Factory
    ),
) {
    val navController = rememberNavController()
    val themeMode by themeTypeViewModel.themeMode.collectAsState()
    when (val currentTHeme = themeMode) {
        null -> SplashScreen()


        else -> {

            val isDarkTheme = when (themeMode) {
                AppTheme.MODE_DAY -> false
                AppTheme.MODE_NIGHT -> true
                AppTheme.MODE_AUTO -> isSystemInDarkTheme()
                else -> isSystemInDarkTheme()
            }
            NumberToWordConverterTheme(
                darkTheme = isDarkTheme,
                dynamicColor = true
            ) {
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        ScreenApp(
                            modifier = modifier,
                            navController = navController,
                        )
                    }
                    composable("settings") {
                        Settings(
                            modifier = modifier,
                            navController = navController,
                            themeMode = currentTHeme,
                            onThemeChange = { themeTypeViewModel.selectTheme(it) }
                        )
                    }
                }


//        CompositionLocalProvider(LocalTheme provides themeMode) {
//            content()
//        }
            }
        }
    }
}

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            // Replace this with your app's logo
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "App Logo",
                modifier = Modifier.size(120.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            // CircularProgressIndicator(progress =)
        }
    }
}