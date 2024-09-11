package io.haider.numbertowordconverter.screenlayer

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.MenuItemColors
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import io.haider.numbertowordconverter.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun DropDownMenu(
    modifier: Modifier=Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    IconButton(onClick = { expanded = true }) {
        Icon(Icons.Default.MoreVert, contentDescription = "Localized description")
    }
    DropdownMenu(
        modifier = modifier.background(MaterialTheme.colorScheme.primaryContainer),
        expanded = expanded,
        onDismissRequest = { expanded = false },
    ) {
//        DropdownMenuItem(
//            text = { Text("Edit") },
//            onClick = { /* Handle edit! */ },
//            leadingIcon = { Icon(Icons.Outlined.Edit, contentDescription = null) }
//        )
        DropdownMenuItem(
            modifier = modifier,
          colors = MenuDefaults.itemColors(
//              leadingIconColor = Color.Cyan,
//              disabledTextColor = Color.Cyan,
              textColor = MaterialTheme.colorScheme.onPrimaryContainer,
//              trailingIconColor = Color.Cyan,
//              disabledLeadingIconColor = Color.Cyan,
//              disabledTrailingIconColor = Color.Cyan
          ),
          //  modifier = modifier.padding(16.dp),
            text = { Text(stringResource(id = R.string.settings_tab)) },
            onClick = { /* Handle settings! */ },
           // leadingIcon = { Icon(Icons.Outlined.Settings, contentDescription =stringResource(id = R.string.settings_tab) ) }
        )
//        HorizontalDivider()
//        DropdownMenuItem(
//            text = { Text("Send Feedback") },
//            onClick = { /* Handle send feedback! */ },
//            leadingIcon = { Icon(Icons.Outlined.Email, contentDescription = null) },
//            trailingIcon = { Text("F11", textAlign = TextAlign.Center) }
//        )
    }
}