package io.haider.numbertowordconverter
import android.icu.text.MessageFormat
import java.util.Locale

class NumberConverter(
    private val number: String
) {

    private fun Double.toWords(language: String, country: String): String {
        val formatter = MessageFormat(
            "{0,spellout,currency}",
            Locale(language, country)
        )
        return formatter.format(arrayOf(this))
    }

fun numToWordArabic():String{
    try {
      return number.toDouble().toWords("ar", "UAE")
    }catch (e:NumberFormatException){null} ?: return "not integer number"

}fun numToWordEnglish():String{
    try {
      return number.toDouble().toWords("en", "UK")
    }catch (e:NumberFormatException){null} ?: return "not integer number"

}
}