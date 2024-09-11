package io.haider.numbertowordconverter.screenlayer

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import io.haider.numbertowordconverter.R
import io.haider.numbertowordconverter.ui.theme.NumberToWordConverterTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenApp(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {

    val focusRequester: FocusRequester = remember {
        FocusRequester()
    }
    val focusManager: FocusManager = LocalFocusManager.current
    val colorScheme = MaterialTheme.colorScheme
    Scaffold(
        modifier = modifier

            .focusRequester(
                focusRequester
            )
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        focusManager.clearFocus()
                    }
                )
            },
        containerColor = colorScheme.background,
        contentColor = colorScheme.onBackground,


        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorScheme.surface,
                    titleContentColor = colorScheme.onSurface,
                ),
                title = {
                    Text(
                        modifier = Modifier,
                        text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.titleMedium,
                        overflow = TextOverflow.Ellipsis
                    )


                },

                actions = {
                    IconButton(
                        onClick = {
                            navController.navigate(route = "settings")
                        },
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Settings,
                            contentDescription = stringResource(id = R.string.settings_tab)
                        )
                    }

                },


                )
        },
    ) { paddingValue ->

        ScreenContents(
            paddingValues = paddingValue, modifier = modifier
        )
    }
}

@Preview
@Composable
fun ScreenAppPreview() {
    NumberToWordConverterTheme {
        ScreenApp(
            modifier = Modifier,
            navController = NavHostController(context = LocalContext.current),

            )
    }
}

//@Preview
//@Composable
//fun DefaultPreview() {
//    NumberToWordConverterTheme {
//        ScreenApp(
//            modifier = Modifier,
//            navController = rememberNavController()
//
//        )
//    }
//}