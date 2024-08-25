package io.haider.numbertowordconverter.uidata

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.haider.numbertowordconverter.R
import io.haider.numbertowordconverter.appdata.CurrencyData

@Composable
fun AddCheckBoxes(
    modifier: Modifier = Modifier,
    currencyData: CurrencyData,
    stringsInfo: StringsInfo,
    onWordCheckedState: (Boolean) -> Unit,
    onNumberCheckedState: (Boolean) -> Unit,
) {
    Column(
        modifier = modifier.padding(horizontal = 16.dp),
        //   horizontalAlignment = Alignment.End,
    ) {
        AddCurrencyName(
            modifier = modifier,
            checked = currencyData.numberChecked,
            onChecked = { checked -> onNumberCheckedState(checked) },
            labelName = stringsInfo.numberCheckBoxName
        )
        AddOnlyWord(
            modifier = modifier,
            checked = currencyData.wordChecked,
            onChecked = { checked -> onWordCheckedState(checked) },
            labelName = stringsInfo.wordCheckBoxName
        )

    }
}

@Composable
fun AddCurrencyName(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onChecked: ((Boolean) -> Unit),
    @StringRes labelName: Int

) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onChecked
        )
        Text(
            modifier = modifier.padding(16.dp),
            text = stringResource(id = labelName)
        )
    }
}

@Composable
fun AddOnlyWord(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onChecked: ((Boolean) -> Unit),
    @StringRes labelName: Int
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onChecked
        )
        Text(
            modifier = modifier.padding(16.dp),
            text = stringResource(id = labelName)

        )

    }
}

@Preview
@Composable
fun AddOnlyWordPreview() {
    AddOnlyWord(checked = false,
        onChecked = {},
        labelName = R.string.app_name)
}

@Preview
@Composable
fun AddCheckBoxesPreview() {
    AddCheckBoxes(currencyData = CurrencyData(), stringsInfo = StringsInfo(
        numberCheckBoxName = R.string.app_name,
        wordCheckBoxName = R.string.app_name
    ), onWordCheckedState = {}) {

    }
}