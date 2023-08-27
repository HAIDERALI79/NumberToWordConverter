package io.haider.numbertowordconverter

import android.annotation.SuppressLint
import android.icu.util.Currency
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.haider.numbertowordconverter.ui.theme.NumberToWordConverterTheme
import java.util.Locale

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            NumberToWordConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

//var number by mutableStateOf("")
//var arabicWord by mutableStateOf("")
//var englishWord by mutableStateOf("")
//var dollarCurrencyState by mutableStateOf("")
//var dinarCurrencyState by mutableStateOf("")
//var dollarLastWord by mutableStateOf("")
//var dinarLastWord by mutableStateOf("")
//var isNameSwitched by mutableStateOf(false)
//var onlyWordSwitch by mutableStateOf(false)
//val dollarCurrency: String = Currency.getInstance("USD").getDisplayName(Locale.UK)
//val iraqCurrency: String = Currency.getInstance("IQD").getDisplayName(Locale("ar", "IQ"))






//fun Modifier.shadows(
//    color: Color = Color.Black,
//    borderRadius: Dp = 0.dp,
//    blurRadius: Dp = 0.dp,
//    modifier: Modifier = Modifier,
//    spread: Dp = 0.dp
//
//) = this.then(
//    drawBehind {
//        this.drawIntoCanvas {
//            val paint = Paint()
//            val framePaint = paint.asFrameworkPaint()
//            val spreadPixel = spread.toPx()
//        }
//    }
//)

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NumberToWordConverterTheme {
        App()
        // AppSwitches()
    }
}