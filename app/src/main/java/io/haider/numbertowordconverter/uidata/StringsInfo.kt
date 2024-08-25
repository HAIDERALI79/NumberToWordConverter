package io.haider.numbertowordconverter.uidata

import androidx.annotation.StringRes
import io.haider.numbertowordconverter.R

data class StringsInfo(
   @StringRes
   val numberCheckBoxName: Int = R.string.empty_string,
   @StringRes
   val wordCheckBoxName: Int = R.string.empty_string,
   @StringRes
   val wrongNumber: Int = R.string.wrong_number,
)