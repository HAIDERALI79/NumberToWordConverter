package io.haider.numbertowordconverter.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import io.haider.numbertowordconverter.BuildConfig
import io.haider.numbertowordconverter.R
import io.haider.numbertowordconverter.settings.theme.ThemeDialog
import io.haider.numbertowordconverter.ui.theme.AppTheme
import io.haider.numbertowordconverter.ui.theme.LocalTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Settings(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    onThemeChange: (AppTheme) -> Unit,


    ) {
    var openAlertDialog by remember {
        mutableStateOf(false)
    }
    var openLicensesDialog by remember {
        mutableStateOf(false)
    }
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
                        onClick = { openAlertDialog = true }
                    )
                    when {
                        (openAlertDialog) -> ThemeDialog(
                            onDismissRequest = { openAlertDialog = false },
                            onConfirmation = { openAlertDialog = false },
                            onThemeChange = onThemeChange,
                            defaultTheme = LocalTheme.current
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
                item {
                    val versionCode = BuildConfig.VERSION_NAME
                    SettingsItem(

                        title = stringResource(id = R.string.version),
                        iconRes = IconRes.PainterRes(painterResource(id = R.drawable.code_24px)),
                        description = versionCode
                    ) {

                    }
                }

                //            item {
                //                SettingsItem(
                //                    title = "Theme",
                //                    iconRes = IconRes.PainterRes(painterResource(id = R.drawable.content_copy)),
                //                    description = "change the Appearance"
                //                ) {
                //
                //                }
                //            }
                item {
                    SettingsItem(
                        title = stringResource(id = R.string.about),
                        iconRes = IconRes.VectorRes(Icons.Default.Info),
                        description = "${stringResource(id = R.string.version)}, ${stringResource(id = R.string.feedback)}"
                    ) {


                    }
                }
                item {
                    Spacer(modifier = Modifier.padding(16.dp))
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { context.startActivity(appShare()) }) {
                            Icon(imageVector = Icons.Default.Share, contentDescription = "")
                        }
                        Text(text = "like")
                        Text(text = "subscribe")
                    }
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
            }

        }

    }
}

@Preview
@Composable
fun SettingsPreview() {
    Settings(navController = NavHostController(context = LocalContext.current)) {

    }
}