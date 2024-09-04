package io.haider.numbertowordconverter

import android.graphics.Color.TRANSPARENT
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.haider.numbertowordconverter.screenlayer.ScreenApp
import io.haider.numbertowordconverter.settings.Settings
import io.haider.numbertowordconverter.settings.theme.UserAppTheme
import io.haider.numbertowordconverter.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(TRANSPARENT, TRANSPARENT)
        )

        setContent {
            var themePreference by remember { mutableStateOf(AppTheme.MODE_AUTO) }
            UserAppTheme(appTheme = themePreference) {

                val navController = rememberNavController()

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier,
                    color = MaterialTheme.colorScheme.background,
                    contentColor = MaterialTheme.colorScheme.onBackground
                    //  modifier = Modifier.fillMaxSize(),
                    //    color = MaterialTheme.colorScheme.background
                ) {

                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") { ScreenApp(navController = navController) }
                        composable("settings") {
                            Settings(
                                navController = navController,
                                onThemeChange = { newTheme -> themePreference = newTheme })
                        }
                    }

                }
            }
        }
    }
}
