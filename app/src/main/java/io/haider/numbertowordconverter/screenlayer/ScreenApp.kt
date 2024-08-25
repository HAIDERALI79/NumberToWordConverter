package io.haider.numbertowordconverter.screenlayer

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.haider.numbertowordconverter.CurrencyViewModel
import io.haider.numbertowordconverter.R
import io.haider.numbertowordconverter.cards.WordsCard
import io.haider.numbertowordconverter.ui.theme.NumberToWordConverterTheme
import io.haider.numbertowordconverter.uidata.AddCheckBoxes
import io.haider.numbertowordconverter.uidata.StringsInfo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(
    modifier: Modifier = Modifier,
    currencyViewModel: CurrencyViewModel = CurrencyViewModel(),

    ) {
    val focusRequester: FocusRequester = remember {
        FocusRequester()
    }
    val focusManager: FocusManager = LocalFocusManager.current
    val currencyDataState = currencyViewModel.currencyState.collectAsState()
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
                    )
                },
                actions = {
                    DropDownMenu()
                },


                )
        },
        modifier = Modifier
            .fillMaxWidth()
            .focusRequester(
                focusRequester
            )
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        focusManager.clearFocus()
                    }
                )
            },
    ) { paddingValue ->


        Column(
            modifier = modifier.padding(paddingValues = paddingValue),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            CurrencyNumber(
                modifier = modifier,
                value = currencyViewModel.inputText.collectAsState().value,
                onValueChange = { value -> currencyViewModel.onTextFieldChanged(value) },
                onClick = { currencyViewModel.clearAllInfo() }
            )
            Spacer(modifier = Modifier.padding(16.dp))
            AddCheckBoxes(
                modifier = modifier,
                currencyData = currencyDataState.value,
                onNumberCheckedState = { check -> currencyViewModel.changeCurrencyState(check) },
                onWordCheckedState = { check -> currencyViewModel.changeWordState(check) },
                stringsInfo = StringsInfo(
                    numberCheckBoxName = R.string.add_Currency,
                    wordCheckBoxName = R.string.add_only_word
                )

            )
            Spacer(modifier = Modifier.padding(16.dp))
            WordsCard(wordString = currencyViewModel.wordCard().second)
            Spacer(modifier = Modifier.padding(vertical = 16.dp))
            WordsCard(wordString = currencyViewModel.wordCard().first)

        }
    }
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NumberToWordConverterTheme {
        App()
        // AppSwitches()
    }
}