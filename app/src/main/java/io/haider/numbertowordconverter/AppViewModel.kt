package io.haider.numbertowordconverter

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import io.haider.numbertowordconverter.appdata.CurrencyConverter
import io.haider.numbertowordconverter.appdata.CurrencyData
import io.haider.numbertowordconverter.appdata.CurrencyType
import io.haider.numbertowordconverter.appdata.TextInputCheck.isPosOrNegNumber
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class CurrencyViewModel(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    companion object {
        private const val CURRENCY_STATE_KEY = "currency_state"
        //      private const val INPUT_TEXT_KEY = "input_text"
    }

    private val _inputText = MutableStateFlow("")
    val inputText: StateFlow<String> get() = _inputText

    private val _currencyState: StateFlow<CurrencyData> =
        savedStateHandle.getStateFlow(CURRENCY_STATE_KEY, CurrencyData())

    val currencyState: StateFlow<CurrencyData> = _currencyState
    fun changeWordState(check: Boolean) {
        savedStateHandle[CURRENCY_STATE_KEY] = _currencyState.value.copy(
            wordChecked = check,
            dinarLastWord = if (check) "فقط لا غير" else "",
            dollarLastWord = if (check) "only" else "",

            )
    }


    fun changeCurrencyState(check: Boolean) {
        val currencyType = CurrencyType()
        savedStateHandle[CURRENCY_STATE_KEY] = _currencyState.value.copy(
            numberChecked = check,
            dinarCurrencyState = if (check) currencyType.iraqCurrency else "",
            dollarCurrencyState = if (check) currencyType.dollarCurrency else ""
        )

    }

    fun wordCard(): Pair<String, String> {
        val item = _currencyState.value
        val arabic = item.arabicWord + " ${item.dinarCurrencyState} ${item.dinarLastWord}"
        val english = item.englishWord + " ${item.dollarCurrencyState} ${item.dollarLastWord}"
        return Pair(english, arabic)
    }

    fun onTextFieldChanged(number: String) {
        if (!number.isPosOrNegNumber()) {
            _inputText.value = ""
            savedStateHandle[CURRENCY_STATE_KEY] = _currencyState.value.copy(
                currencyNumber = "",
                dinarLastWord = "",
                dollarLastWord = "",
                dollarCurrencyState = "",
                dinarCurrencyState = "",
                englishWord = "empty or not a number",
                arabicWord = "الحقل فارغ او الرقم الذي ادخلته غير صحيح"
            )

        } else {
            val (english, arabic) = CurrencyConverter(number).convertToWord()
            changeCurrencyState(_currencyState.value.numberChecked)
            changeWordState(_currencyState.value.wordChecked)
            _inputText.value = number
            savedStateHandle[CURRENCY_STATE_KEY] = _currencyState.value.copy(
                englishWord = english,
                arabicWord = arabic,
            )
        }
    }


    fun clearAllInfo() {
        _inputText.value = ""
        savedStateHandle[CURRENCY_STATE_KEY] = _currencyState.value.copy(
            currencyNumber = "",
        )

    }
}


