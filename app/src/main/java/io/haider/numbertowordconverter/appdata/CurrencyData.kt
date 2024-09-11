package io.haider.numbertowordconverter.appdata

import android.icu.util.Currency
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Locale

@Parcelize
data class CurrencyData(
    val currencyNumber: String = "",
    val arabicWord: String = "",
    val englishWord: String = "",
    val dollarCurrencyState: String = "",
    val dinarCurrencyState: String = "",
    val dollarLastWord: String = "",
    val dinarLastWord: String = "",
    val numberChecked: Boolean = false,
    val wordChecked: Boolean = false,
) : Parcelable

data class CurrencyType(
    val dollarCurrency: String = Currency.getInstance("USD").getDisplayName(Locale.UK),
    val iraqCurrency: String =
        Currency.getInstance("IQD").getDisplayName(Locale("ar", "IQ"))
)