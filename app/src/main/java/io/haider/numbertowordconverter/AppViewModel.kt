package io.haider.numbertowordconverter

import android.icu.util.Currency
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapLatest
import java.util.Locale

class AppViewModel : ViewModel() {
    var number by mutableStateOf("")
    var arabicWord by mutableStateOf("")
    var englishWord by mutableStateOf("")
    var dollarCurrencyState by mutableStateOf("")
    var dinarCurrencyState by mutableStateOf("")
    var dollarLastWord by mutableStateOf("")
    var dinarLastWord by mutableStateOf("")
    var isNameSwitched by mutableStateOf(false)
    var onlyWordSwitch by mutableStateOf(false)
    val dollarCurrency: String = Currency.getInstance("USD").getDisplayName(Locale.UK)
    val iraqCurrency: String = Currency.getInstance("IQD").getDisplayName(Locale("ar", "IQ"))
}

class SavedStateViewModel(private val state: SavedStateHandle) : ViewModel() {
  // val filteredData: StateFlow<List<String>> =
//           state.getStateFlow<String>("k").flatMapLatest {query ->
//
//           }
    val haider=""
   // val data:LiveData<List<String>>=
}
//class SavedStateViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
//    val filteredData: LiveData<List<String>> = savedStateHandle.getLiveData<String>("query").switchMap { query ->
//            repository.getFilteredData(query)
//        }
