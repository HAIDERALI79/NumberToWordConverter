package io.haider.numbertowordconverter

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun App() {
    val viewModel =AppViewModel()
    Scaffold(
        modifier = Modifier.fillMaxWidth(),
    ) {


        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "change Number to words",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
            )
            Row(
                Modifier.padding(start = 10.dp, end = 10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    modifier = Modifier.padding(end = 8.dp),
                    value = viewModel.number,
                    onValueChange = { viewModel.number = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true,
                )
                Box(
                    modifier = Modifier.padding(start = 8.dp),
                ) {
                    IconButton(
                        onClick = {
                            viewModel.number = ""
                            viewModel.arabicWord = ""
                            viewModel.englishWord = ""
                            viewModel.dollarCurrencyState = ""
                            viewModel.dinarCurrencyState = ""
                            viewModel.dollarLastWord = ""
                            viewModel.dinarLastWord = ""
                            viewModel.isNameSwitched = false
                            viewModel.onlyWordSwitch = false
                        },

                        ) {

                        Icon(imageVector = Icons.Default.Delete, contentDescription = "Clear")

                    }
                }
            }
            if (viewModel.number.isNotEmpty()) {
                viewModel.arabicWord = NumberConverter(viewModel.number).numToWordArabic()
                viewModel.englishWord = NumberConverter(viewModel.number).numToWordEnglish()
            }
            Spacer(modifier = Modifier.padding(16.dp))
           Switches(

           )
            Spacer(modifier = Modifier.padding(16.dp))
            WordsCard(wordString = "${viewModel.arabicWord} ${viewModel.dinarCurrencyState} ${viewModel.dinarLastWord}")
            WordsCard(wordString = "${viewModel.englishWord} ${viewModel.dollarCurrencyState} ${viewModel.dollarLastWord}")

        }
    }
}
