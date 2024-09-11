//package io.haider.numbertowordconverter.ui.theme
//import androidx.compose.animation.AnimatedVisibility
//import androidx.compose.animation.core.Spring
//import androidx.compose.animation.core.spring
//import androidx.compose.animation.fadeIn
//import androidx.compose.animation.fadeOut
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Close
//import androidx.compose.material.icons.rounded.Call
//import androidx.compose.material.icons.rounded.Share
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.Checkbox
//import androidx.compose.material3.CheckboxDefaults
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBar
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun ModernNumberToWordConverter() {
//    var number by remember { mutableStateOf("") }
//    var addCurrency by remember { mutableStateOf(false) }
//    var addOnlyWord by remember { mutableStateOf(false) }
//
//    val surfaceColor = MaterialTheme.colorScheme.surfaceVariant
//    val primaryColor = MaterialTheme.colorScheme.primary
//
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//                    Text(
//                        "Number to Word",
//                        style = MaterialTheme.typography.headlineSmall,
//                        fontWeight = FontWeight.Bold
//                    )
//                },
//                actions = {
//                    IconButton(onClick = { /* Handle close action */ }) {
//                        Icon(Icons.Default.Close, contentDescription = "Close")
//                    }
//                },
////                colors = TopAppBarDefaults.Top(
////                    containerColor = surfaceColor
////                )
//            )
//        },
//        containerColor = surfaceColor
//    ) { innerPadding ->
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(innerPadding)
//                .padding(16.dp),
//            verticalArrangement = Arrangement.spacedBy(16.dp)
//        ) {
//            Card(
//                modifier = Modifier.fillMaxWidth(),
//                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
//                shape = RoundedCornerShape(16.dp)
//            ) {
//                Column(modifier = Modifier.padding(16.dp)) {
//                    OutlinedTextField(
//                        value = number,
//                        onValueChange = { number = it },
//                        label = { Text("Enter number") },
//                        modifier = Modifier.fillMaxWidth(),
//                        shape = RoundedCornerShape(12.dp),
////                        colors = androidx.compose.material3.TextFieldDefaults.colors(
////                            focusedBorderColor = primaryColor,
////                            focusedLabelColor = primaryColor
////                        )
//                    )
//
//                    Spacer(modifier = Modifier.height(16.dp))
//
//                    LabelledCheckbox(
//                        checked = addCurrency,
//                        onCheckedChange = { addCurrency = it },
//                        label = "Add currency name at the end"
//                    )
//
//                    LabelledCheckbox(
//                        checked = addOnlyWord,
//                        onCheckedChange = { addOnlyWord = it },
//                        label = "Add only word"
//                    )
//                }
//            }
//
//            AnimatedVisibility(
//                visible = number.isEmpty(),
//                enter = fadeIn(animationSpec = spring(stiffness = Spring.StiffnessLow)),
//                exit = fadeOut(animationSpec = spring(stiffness = Spring.StiffnessLow))
//            ) {
//                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
//                    ResultCard(title = "Number in words")
//                    ResultCard(title = "Currency in words")
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun LabelledCheckbox(
//    checked: Boolean,
//    onCheckedChange: (Boolean) -> Unit,
//    label: String
//) {
//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier.clip(RoundedCornerShape(8.dp))
//    ) {
//        Checkbox(
//            checked = checked,
//            onCheckedChange = onCheckedChange,
//            colors = CheckboxDefaults.colors(
//                checkedColor = MaterialTheme.colorScheme.primary,
//                checkmarkColor = MaterialTheme.colorScheme.onPrimary
//            )
//        )
//        Text(label, style = MaterialTheme.typography.bodyMedium)
//    }
//}
//
//@Composable
//fun ResultCard(title: String) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(100.dp),
//        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
//        shape = RoundedCornerShape(16.dp)
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp)
//        ) {
//            Text(
//                text = title,
//                style = MaterialTheme.typography.titleMedium,
//                color = MaterialTheme.colorScheme.primary
//            )
//            Spacer(modifier = Modifier.weight(1f))
//            Row(
//                modifier = Modifier.align(Alignment.End),
//                horizontalArrangement = Arrangement.spacedBy(8.dp)
//            ) {
//                ActionButton(icon = Icons.Rounded.Call, description = "Copy")
//                ActionButton(icon = Icons.Rounded.Share, description = "Share")
//            }
//        }
//    }
//}
//
//@Composable
//fun ActionButton(icon: ImageVector, description: String) {
//    IconButton(
//        onClick = { /* Handle action */ },
//        modifier = Modifier
//            .size(36.dp)
//            .clip(RoundedCornerShape(8.dp))
//    ) {
//        Icon(icon, contentDescription = description, tint = MaterialTheme.colorScheme.primary)
//    }
//}
//
//@Preview
//@Composable
//fun ModernAPP() {
//    ModernNumberToWordConverter()
//}