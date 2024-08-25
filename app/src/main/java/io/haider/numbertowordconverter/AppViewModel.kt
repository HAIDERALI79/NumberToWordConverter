package io.haider.numbertowordconverter

import android.icu.util.Currency
import androidx.lifecycle.ViewModel
import io.haider.numbertowordconverter.appdata.CurrencyConverter
import io.haider.numbertowordconverter.appdata.CurrencyData
import io.haider.numbertowordconverter.appdata.TextInputCheck.isPosOrNegNumber
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.Locale

class CurrencyViewModel : ViewModel() {
    private val dollarCurrency: String = Currency.getInstance("USD").getDisplayName(Locale.UK)
    private val iraqCurrency: String =
        Currency.getInstance("IQD").getDisplayName(Locale("ar", "IQ"))
    private val _inputText = MutableStateFlow("")
    val inputText: StateFlow<String> get() = _inputText
    private val _currencyState = MutableStateFlow(CurrencyData())
    val currencyState: StateFlow<CurrencyData> = _currencyState.asStateFlow()
    fun changeWordState(check: Boolean) {
        _currencyState.update { items ->
            items.copy(
                wordChecked = check,
                dinarLastWord = if (check) "فقط لا غير" else "",
                dollarLastWord = if (check) "only" else "",

                )
        }
    }

    fun changeCurrencyState(check: Boolean) {
        _currencyState.update { items ->
            items.copy(
                numberChecked = check,
                dinarCurrencyState = if (check) iraqCurrency else "",
                dollarCurrencyState = if (check) dollarCurrency else ""
            )

        }
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
            _currencyState.update { items ->
                items.copy(
                    currencyNumber = "",
                    dinarLastWord = "",
                    dollarLastWord = "",
                    dollarCurrencyState = "",
                    dinarCurrencyState = "",
                    englishWord = "empty or not a number",
                    arabicWord = "الحقل فارغ او الرقم الذي ادخلته غير صحيح"
                )
            }
        } else {
            val (english, arabic) = CurrencyConverter(number).convertToWord()
            changeCurrencyState(_currencyState.value.numberChecked)
            changeWordState(_currencyState.value.wordChecked)
            _inputText.value = number
            _currencyState.update { items ->
                items.copy(
                    englishWord = english,
                    arabicWord = arabic,
                )
            }
        }
    }

    fun clearAllInfo() {
        _inputText.value = ""
        _currencyState.update { items ->
            items.copy(
                currencyNumber = "",
            )

        }
    }
}
