package io.haider.numbertowordconverter.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SettingsItem(
    modifier: Modifier = Modifier,
    title: String,
    iconRes: IconRes,
    description: String,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier.clickable {
            onClick()
        }
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            when (iconRes) {
                is IconRes.PainterRes -> {
                    Icon(painter = iconRes.painter, contentDescription = title)
                }

                is IconRes.VectorRes -> {
                    Icon(imageVector = iconRes.imageVector, contentDescription = title)

                }

            }
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    //  fontFamily = FontFamily.Default,
                    // fontSize = 20.sp

                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,

                    //      fontSize = 20.sp
                )
            }
        }
    }
}

