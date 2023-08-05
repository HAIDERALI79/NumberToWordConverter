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
import io.haider.numbertowordconverter.dinarCurrencyState
import io.haider.numbertowordconverter.dinarLastWord
import io.haider.numbertowordconverter.dollarCurrency
import io.haider.numbertowordconverter.dollarCurrencyState
import io.haider.numbertowordconverter.dollarLastWord
import io.haider.numbertowordconverter.iraqCurrency
import io.haider.numbertowordconverter.isNameSwitched
import io.haider.numbertowordconverter.onlyWordSwitch

public class AppSwitches {
    @Composable
    fun Switches() {
        Column (
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp)
                .fillMaxWidth(),
        ){

            Row(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "add Currency name in the end")
                Checkbox(checked = isNameSwitched , onCheckedChange = {
                    isNameSwitched = it
                    if (isNameSwitched) {
                        dollarCurrencyState = dollarCurrency
                        dinarCurrencyState = iraqCurrency
                    } else {
                        dinarCurrencyState = ""
                        dollarCurrencyState = ""
                    }

                })
//            Switch(
//                checked = isNameSwitched,
//                onCheckedChange = {
//                    isNameSwitched = it
//                    if (isNameSwitched) {
//                        dollarCurrencyState = dollarCurrency
//                        dinarCurrencyState = iraqCurrency
//                    } else {
//                        dinarCurrencyState = ""
//                        dollarCurrencyState = ""
//                    }
//                },
//            )
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
                    checked = onlyWordSwitch,
                    onCheckedChange = {
                        onlyWordSwitch = it
                        if (onlyWordSwitch) {
                            dollarLastWord = "only"
                            dinarLastWord = "ققط لا غير"
                        } else {
                            dollarLastWord = ""
                            dinarLastWord = ""
                        }
                    },
                )
            }
        }
    }
}