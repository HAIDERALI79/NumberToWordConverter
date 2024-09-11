package io.haider.numbertowordconverter.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import io.haider.numbertowordconverter.BuildConfig
import io.haider.numbertowordconverter.R
import io.haider.numbertowordconverter.settings.theme.ThemeDialog
import io.haider.numbertowordconverter.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Settings(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    onThemeChange: (AppTheme) -> Unit,
    themeMode: AppTheme,
) {
    var openThemeDialog by remember {
        mutableStateOf(false)
    }
    var openAboutDialog by remember {
        mutableStateOf(false)
    }
//    var openLicensesDialog by remember {
//        mutableStateOf(false)
//    }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(
                        modifier = Modifier,
                        text = stringResource(id = R.string.settings_tab),
                        style = MaterialTheme.typography.titleLarge,
                        overflow = TextOverflow.Ellipsis,
                        // fontSize = 30.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigateUp()

                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "back"
                        )
                    }
                }

            )
        }
    ) {
        Surface {
            LazyColumn(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                contentPadding = it
            ) {
                item {
                    SettingsItem(
                        title = stringResource(id = R.string.color_scheme),
                        iconRes = IconRes.PainterRes(painterResource(id = R.drawable.brightness_6_24px)),
                        description = stringResource(id = R.string.change_appearance),
                        onClick = { openThemeDialog = true }
                    )
                    when {
                        (openThemeDialog) -> ThemeDialog(
                            onDismissRequest = { openThemeDialog = false },
                            onConfirmation = { openThemeDialog = false },
                            onThemeChange = onThemeChange,
                            themeMode = themeMode
                            //    LocalTheme.current
                        )
                    }

                }
                item {
                    SettingsItem(
                        title = stringResource(id = R.string.feedback),
                        iconRes = IconRes.PainterRes(painterResource(id = R.drawable.mail_24px)),
                        description = stringResource(id = R.string.feedback)
                    ) {
                        context.startActivity(
                            sendToEmail("haiderali5c@outlook.com")
                        )
                    }
                }
//                item {
//                    val versionCode = BuildConfig.VERSION_NAME
//                    SettingsItem(
//
//                        title = stringResource(id = R.string.version),
//                        iconRes = IconRes.PainterRes(painterResource(id = R.drawable.code_24px)),
//                        description = versionCode
//                    ) {
//
//                    }
//                }
                item {
                    SettingsItem(
                        title = stringResource(id = R.string.about),
                        iconRes = IconRes.VectorRes(Icons.Default.Info),
                        description = "${stringResource(id = R.string.version)}," +
                                " ${stringResource(id = R.string.feedback)}",
                        onClick = { openAboutDialog = true }
                    )
                    when {
                        (openAboutDialog) -> AboutDialog(
                            onDismissRequest = { openAboutDialog = false },
                            onConfirmation = { openAboutDialog = false },
                        )
                    }

                }
                item {
                    Row(
                        modifier = modifier
                            .padding(horizontal = 24.dp, vertical = 16.dp)
                            .fillMaxWidth(),

                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { context.startActivity(appShare()) }) {
                            Icon(imageVector = Icons.Default.Share, contentDescription = "")
                        }
                        IconButton(onClick = {openAppProfile(appUrl = "https://x.com/HAIDA5C", context = context) }) {
                            Box(
                                modifier = modifier.padding(8.dp),

                                ) {
                                Icon(
                                    painter = painterResource(R.drawable.x_twitter),
                                    contentDescription = "twitter"
                                )
                            }
                        }
                        IconButton(onClick = { openAppProfile(appUrl = "https://www.instagram.com/haider5c", context = context) }) {
                            Icon(
                                painter = painterResource(R.drawable.instagram),
                                contentDescription = "instagram"
                            )
                        }
                    }
                }
                item {
                    Spacer(Modifier.padding(vertical = 16.dp))
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        val versionCode = BuildConfig.VERSION_NAME
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            // Replace this with your app's logo
                            Image(
                                painter = painterResource(id = R.drawable.ic_launcher_round),
                                contentDescription = "App Logo",
                                modifier = Modifier.size(100.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text=versionCode,
                                style = TextStyle(
                                    fontFamily = FontFamily.Serif
                                )
                            )
                            // CircularProgressIndicator(progress =)
                        }
                    }
                }

            }

        }

    }
}

@Preview
@Composable
fun SettingsPreview() {
    Settings(

        navController = NavHostController(context = LocalContext.current),
        onThemeChange = {},
        themeMode = AppTheme.MODE_AUTO,

        )
}


//            item {
//                SettingsItem(title = "license",
//                    iconRes = IconRes.VectorRes(Icons.Filled.Warning),
//                    description = "license information and open source notices",
//
//                    onClick = {
//                   openLicensesDialog =true
//                    }
//
//                )
//                when (openLicensesDialog) {
//                    true -> LazyColumn {
//                        item {
//                            context.startActivity(Intent(context, OssLicensesMenuActivity::class.java))
//
//                        }
//                    }
//                    false -> {}
//                }
//            }
//            item {
//
//                Button(onClick = { openAlertDialog = true }) {
//                    when {
//                        (openAlertDialog) -> ThemeDialog(
//                            onDismissRequest = { openAlertDialog = false },
//                            onConfirmation = { openAlertDialog = false },
//                            onThemeChange = onThemeChange,
//                            defaultTheme = LocalTheme.current
//                        )
//                    }
//                }
//            }