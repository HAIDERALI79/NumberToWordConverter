package io.haider.numbertowordconverter.screenlayer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.haider.numbertowordconverter.R
import io.haider.numbertowordconverter.appdata.CurrencyData
import io.haider.numbertowordconverter.uidata.AddCheckBoxes
import io.haider.numbertowordconverter.uidata.StringsInfo


@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    onClick: () -> Unit,
    currencyData: CurrencyData,
    onNumberCheckedState: (Boolean) -> Unit,
    onWordCheckedState: (Boolean) -> Unit

) {
    Card(
        modifier = modifier.padding(horizontal = 16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            //    verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Box(
                modifier = modifier.padding(top = 16.dp)
            ) {
                NumberSearchBar(
                    //  value = currencyViewModel.inputText.collectAsState().value,
                    value = value,
                    onValueChange = onValueChange,
                    // onValueChange = { value -> currencyViewModel.onTextFieldChanged(value) },
                    onClick = onClick
                    //    onClick = { currencyViewModel.clearAllInfo() }
                )
            }
            Spacer(modifier = Modifier.padding(16.dp))
            AddCheckBoxes(
                modifier = modifier,
                //  currencyData = currencyDataState.value,
                currencyData = currencyData,
                onNumberCheckedState = onNumberCheckedState,
                onWordCheckedState = onWordCheckedState,
                stringsInfo = StringsInfo(
                    numberCheckBoxName = R.string.add_Currency,
                    wordCheckBoxName = R.string.add_only_word
                )
            )

//                onNumberCheckedState = { check ->
//                    currencyViewModel.changeCurrencyState(
//                        check
//                    )
//                },
//                onWordCheckedState =
//                { check -> currencyViewModel.changeWordState(check) },
//                stringsInfo = StringsInfo(
//                    numberCheckBoxName = R.string.add_Currency,
//                    wordCheckBoxName = R.string.add_only_word
//                )
//
//            )
        }
    }
}