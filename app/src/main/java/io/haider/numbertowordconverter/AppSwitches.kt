package io.haider.numbertowordconverter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Switches(
) {
    val viewModel = AppViewModel()
    Column(
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp)
            .fillMaxWidth(),
    ) {

        Row(
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "add Currency name in the end")
            Checkbox(checked = viewModel.isNameSwitched, onCheckedChange = {
                viewModel.isNameSwitched = it
                if (viewModel.isNameSwitched) {
                    viewModel.dollarCurrencyState = viewModel.dollarCurrency
                    viewModel.dinarCurrencyState = viewModel.iraqCurrency
                } else {
                    viewModel.dinarCurrencyState = ""
                    viewModel.dollarCurrencyState = ""
                }

            })
        }
        Row(
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {

            Text(text = "add only word in the end")
            Checkbox(
                checked = viewModel.onlyWordSwitch,
                onCheckedChange = {
                    viewModel.onlyWordSwitch = it
                    if (viewModel.onlyWordSwitch) {
                        viewModel.dollarLastWord = "only"
                        viewModel.dinarLastWord = "ققط لا غير"
                    } else {
                        viewModel.dollarLastWord = ""
                        viewModel.dinarLastWord = ""
                    }
                },
            )
        }
    }
}