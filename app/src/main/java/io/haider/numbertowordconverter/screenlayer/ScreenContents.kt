package io.haider.numbertowordconverter.screenlayer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import io.haider.numbertowordconverter.CurrencyViewModel
import io.haider.numbertowordconverter.cards.WordsCard


@Composable
fun ScreenContents(
    modifier: Modifier = Modifier,
    currencyViewModel: CurrencyViewModel = viewModel(),
    paddingValues: PaddingValues,
) {
    val currencyDataState = currencyViewModel.currencyState.collectAsState()
    Surface(
        modifier = modifier
    ) {
        Column(
            modifier = modifier
                .verticalScroll(rememberScrollState())
                .padding(paddingValues = paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {
            Spacer(modifier = Modifier.padding(16.dp))
            SearchScreen(
                value = currencyViewModel.inputText.collectAsState().value,
                onValueChange = { value -> currencyViewModel.onTextFieldChanged(value) },
                onClick = { currencyViewModel.clearAllInfo() },
                currencyData = currencyDataState.value,
                onNumberCheckedState = { check -> currencyViewModel.changeCurrencyState(check) },
                onWordCheckedState = { check -> currencyViewModel.changeWordState(check) },
            )
            //  Spacer(modifier = Modifier.padding(16.dp))
            WordsCard(wordString = currencyViewModel.wordCard().second)
            //  Spacer(modifier = Modifier.padding(vertical = 16.dp))
            WordsCard(wordString = currencyViewModel.wordCard().first)

        }

    }
}

//@RequiresApi(Build.VERSION_CODES.TIRAMISU)
//@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
//@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
//@Composable
//fun DefaultPreview() {
//    NumberToWordConverterTheme {
//        ScreenContents(
//            modifier = Modifier,
//            paddingValues = PaddingValues(8.dp),
//        )
//    }
//}