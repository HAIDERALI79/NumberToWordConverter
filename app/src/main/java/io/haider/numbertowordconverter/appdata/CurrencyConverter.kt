package io.haider.numbertowordconverter.appdata
import android.icu.text.MessageFormat
import android.icu.util.Currency
import io.haider.numbertowordconverter.uidata.StringsInfo
import java.util.Locale

class CurrencyConverter(
private val number: String
) {

    private fun Double?.toWords(language: String, country: String): String {
        val formatter = MessageFormat(
            "{0,spellout,currency}",
            Locale(language, country)
        )
        return formatter.format(arrayOf(this))
    }
//  private  fun String?.isPosOrNegNumber() : Boolean {
//        val regex = """^(-)?[0-9]*((\.)[0-9]+)?$""".toRegex()
//        return if (this==null) false
//        else regex.matches(this)
//    }
private fun numToWordArabic(number: String):String=
//   try {
// if (number.isPosOrNegNumber())
number.toDouble().toWords("ar", "UAE")
    // else "الرقم الذي ادخلته غير صحيح"
//    } catch (e:NumberFormatException){null
//    }?: ""
        //?: return "الرقم الذي ادخلته غير صحيح"

private fun numToWordEnglish(number: String)=
//    try {
//     if (number.isPosOrNegNumber())
         number.toDouble().toWords("en", "UK")
    //else "not integer number"
   // }catch (e:NumberFormatException){null} ?:  ""

//}
 fun  convertToWord():Pair<String,String>{
val englishWord=numToWordEnglish(number)
    val  arabicWord=numToWordArabic(number)
    return  Pair(first =  englishWord, second =  arabicWord)
    }
}