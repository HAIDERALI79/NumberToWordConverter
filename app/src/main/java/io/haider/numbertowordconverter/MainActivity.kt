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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
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
                    NumberToWord()
                }
            }
        }
    }
}
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun NumberToWord() {
    Scaffold(
        modifier = Modifier.fillMaxWidth(),
    ) {


        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "change Number to words",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
            )
            Row(
                Modifier.padding(start = 10.dp, end = 10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    modifier = Modifier.padding(end = 8.dp),
                    value = number,
                    onValueChange = { number = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true,
                )
                Box(
                    modifier = Modifier.padding(start = 8.dp),
                ) {
                    IconButton(
                        onClick = {
                            number = ""
                            arabicWord = ""
                            englishWord = ""
                            dollarCurrencyState = ""
                            dinarCurrencyState = ""
                            dollarLastWord = ""
                            dinarLastWord = ""
                            isNameSwitched = false
                            onlyWordSwitch = false
                        },

                        ) {

                        Icon(imageVector = Icons.Default.Delete, contentDescription = "Clear")

                    }
                }
            }
            if (number.isNotEmpty()) {
                arabicWord = NumberConverter(number).numToWordArabic()
                englishWord = NumberConverter(number).numToWordEnglish()
            }
            Spacer(modifier = Modifier.padding(16.dp))
            AppSwitches().Switches()
            Spacer(modifier = Modifier.padding(16.dp))
            WordsCard()

        }
    }
}

@Composable
fun WordsCard() {
    val clipboardManager: ClipboardManager = LocalClipboardManager.current
    Column {


        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .shadows(
                    borderRadius = 5.dp,
                    blurRadius = 5.dp

                )
        ) {
            val (content, fab) = createRefs()
            Box(
                modifier = Modifier.constrainAs(content) {
                    top.linkTo(parent.top, margin = 16.dp)

                }
            ) {
                Text(
                    text = "$arabicWord $dinarCurrencyState $dinarLastWord",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            FloatingActionButton(
                modifier = Modifier
                    .defaultMinSize(
                        minWidth = 40.dp,
                        minHeight = 40.dp,
                    )
                    .constrainAs(fab) {
                        end.linkTo(parent.end, margin = 8.dp)
                        bottom.linkTo(parent.bottom, margin = 8.dp)
                        top.linkTo(content.bottom)
                    },
                onClick = {
                    clipboardManager.setText(
                        annotatedString = AnnotatedString(
                            "$arabicWord $dinarCurrencyState $dinarLastWord"
                        )
                    )
                },
                shape = ShapeDefaults.ExtraLarge,
                elevation = FloatingActionButtonDefaults.elevation()

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.content_copy),
                    contentDescription = "copy"
                )


            }
        }
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .shadow(
                    elevation = 2.dp
                )
        ) {
            val (text, button) = createRefs()
            Box(modifier = Modifier
                .padding(8.dp)
                .constrainAs(text) {
                    top.linkTo(parent.top)
                }) {
                Text(
                    text = "$englishWord $dollarCurrencyState $dollarLastWord",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            FloatingActionButton(
                modifier = Modifier
                    .defaultMinSize(
                        minWidth = 40.dp,
                        minHeight = 40.dp,
                    )
                    .constrainAs(button) {
                        end.linkTo(parent.end, margin = 8.dp)
                        bottom.linkTo(parent.bottom, margin = 8.dp)
                        top.linkTo(text.bottom)
                    },
                onClick = {
                    clipboardManager.setText(
                        annotatedString = AnnotatedString(
                            "$englishWord $dollarCurrencyState $dollarLastWord"
                        )
                    )
                },
                shape = ShapeDefaults.ExtraLarge,
                elevation = FloatingActionButtonDefaults.elevation()

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.content_copy),
                    contentDescription = "copy"
                )


            }
        }
    }
}


fun Modifier.shadows(
    color: Color = Color.Black,
    borderRadius: Dp =0.dp,
    blurRadius:Dp=0.dp,
    modifier: Modifier=Modifier,
    spread:Dp=0.dp

)=this.then(
    drawBehind {
this.drawIntoCanvas {
    val paint= Paint()
    val framePaint=paint.asFrameworkPaint()
    val spreadPixel=spread.toPx()
}
    }
)
@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NumberToWordConverterTheme {
        NumberToWord()
        // AppSwitches()
        //   WordsCard()
    }
}