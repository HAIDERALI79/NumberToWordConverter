package io.haider.numbertowordconverter.settings.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import io.haider.numbertowordconverter.R
import io.haider.numbertowordconverter.ui.theme.AppTheme


@Composable
fun ThemeDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    onThemeChange: (AppTheme) -> Unit,
    themeMode: AppTheme,
) {
    //   var selectedTheme by remember { mutableStateOf(defaultTheme) }
    val typography = MaterialTheme.typography
    Dialog(onDismissRequest = onDismissRequest) {
        Card(
            modifier = modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
        ) {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(id = R.string.choose_theme),
                    style = typography.labelLarge

                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                //   verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
            ) {
                AppTheme.values().forEach { theme ->
                    LabeledRadioButton(
                        selected = theme == themeMode,
                        onSelect = { onThemeChange(theme) },
                        theme = theme

                        //     onSelect = { themeTypeViewModel.selectTheme(AppTheme.MODE_AUTO) },
                    )

                }
                Row(
                    modifier = Modifier
                        .padding(
                            top = 16.dp
                        )
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {
                    TextButton(
                        onClick = onDismissRequest,
                        //  modifier = Modifier.padding(8.dp),
                    ) {
                        Text(
                            stringResource(id = R.string.cancel),
                            style = typography.labelMedium
                        )
                    }
                    TextButton(
                        onClick = {
                            onThemeChange(themeMode)
                            onConfirmation()
                        },
                        //   modifier = Modifier.padding(8.dp),
                    ) {
                        Text(
                            stringResource(id = R.string.ok),
                            style = typography.labelMedium
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun LabeledRadioButton(
    selected: Boolean,
    onSelect: () -> Unit,
    //  label: String,
    theme: AppTheme
) {
    Row(
        modifier = Modifier
            .selectable(
                selected = selected,
                onClick = onSelect
            )
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        RadioButton(
            selected = selected,
            onClick = null,
        )
        Text(
            text = when (theme) {
                AppTheme.MODE_AUTO -> stringResource(id = R.string.system_default)
                AppTheme.MODE_NIGHT -> stringResource(id = R.string.dark)
                AppTheme.MODE_DAY -> stringResource(id = R.string.light)
            },
            style = MaterialTheme.typography.labelMedium

        )
    }
}

@Preview
@Composable
fun ThemeDialogPreview() {
    ThemeDialog(
        onDismissRequest = { /*TODO*/ },
        onConfirmation = { /*TODO*/ },
        onThemeChange = {},
        themeMode = AppTheme.MODE_AUTO
    )
}