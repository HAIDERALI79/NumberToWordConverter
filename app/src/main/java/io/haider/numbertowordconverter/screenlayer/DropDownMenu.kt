package io.haider.numbertowordconverter.screenlayer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun DropDownMenu() {
    var expanded by remember { mutableStateOf(false) }
    IconButton(onClick = { expanded = true }) {
        Icon(Icons.Default.MoreVert, contentDescription = "Localized description")
    }
    DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
//        DropdownMenuItem(
//            text = { Text("Edit") },
//            onClick = { /* Handle edit! */ },
//            leadingIcon = { Icon(Icons.Outlined.Edit, contentDescription = null) }
//        )
        DropdownMenuItem(
            text = { Text("Settings") },
            onClick = { /* Handle settings! */ },
            leadingIcon = { Icon(Icons.Outlined.Settings, contentDescription = "Settings") }
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