package io.haider.numbertowordconverter
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.haider.numbertowordconverter.ui.theme.NumberToWordConverterTheme

@Composable
fun WordsCard(
    modifier: Modifier = Modifier,
    wordString: String,
) {
    val clipboardManager: ClipboardManager = LocalClipboardManager.current
    //  val wordString = "$arabicWord $dinarCurrencyState $dinarLastWord"

    Card(
        modifier = modifier.padding(horizontal = 16.dp, vertical = 16.dp),
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = wordString,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
       //     Spacer(modifier = modifier.padding(bottom = 10.dp))

            Box(
                 modifier = modifier.align(alignment = Alignment.End),
             //   contentAlignment = Alignment.BottomEnd
            ) {
                IconButton(
                    modifier = modifier.clip(CircleShape),
                    onClick = {
                        clipboardManager.setText(
                            annotatedString = AnnotatedString(
                                wordString
                            )
                        )
                    },

                    ) {
                    Icon(
                        painter = painterResource(id = R.drawable.content_copy),
                        contentDescription = "copy"
                    )


                }
            }
        }
    }

//        ConstraintLayout(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp)
//                .shadows(
//                    borderRadius = 5.dp,
//                    blurRadius = 5.dp
//
//                )
//        ) {
//            val (content, fab) = createRefs()
//            Box(
//                modifier = Modifier.constrainAs(content) {
//                    top.linkTo(parent.top, margin = 16.dp)
//
//                }
//            ) {
//                Text(
//                    text = "$arabicWord $dinarCurrencyState $dinarLastWord",
//                    style = MaterialTheme.typography.bodyMedium
//                )
//            }
//            FloatingActionButton(
//                modifier = Modifier
//                    .defaultMinSize(
//                        minWidth = 40.dp,
//                        minHeight = 40.dp,
//                    )
//                    .constrainAs(fab) {
//                        end.linkTo(parent.end, margin = 8.dp)
//                        bottom.linkTo(parent.bottom, margin = 8.dp)
//                        top.linkTo(content.bottom)
//                    },
//                onClick = {
//                    clipboardManager.setText(
//                        annotatedString = AnnotatedString(
//                            "$arabicWord $dinarCurrencyState $dinarLastWord"
//                        )
//                    )
//                },
//                shape = ShapeDefaults.ExtraLarge,
//                elevation = FloatingActionButtonDefaults.elevation()
//
//            ) {
//                Icon(
//                    painter = painterResource(id = R.drawable.content_copy),
//                    contentDescription = "copy"
//                )
//
//
//            }
//        }
//        ConstraintLayout(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp)
//                .shadow(
//                    elevation = 2.dp
//                )
//        ) {
//            val (text, button) = createRefs()
//            Box(modifier = Modifier
//                .padding(8.dp)
//                .constrainAs(text) {
//                    top.linkTo(parent.top)
//                }) {
//                Text(
//                    text = "$englishWord $dollarCurrencyState $dollarLastWord",
//                    style = MaterialTheme.typography.bodyMedium
//                )
//            }
//            FloatingActionButton(
//                modifier = Modifier
//                    .defaultMinSize(
//                        minWidth = 40.dp,
//                        minHeight = 40.dp,
//                    )
//                    .constrainAs(button) {
//                        end.linkTo(parent.end, margin = 8.dp)
//                        bottom.linkTo(parent.bottom, margin = 8.dp)
//                        top.linkTo(text.bottom)
//                    },
//                onClick = {
//                    clipboardManager.setText(
//                        annotatedString = AnnotatedString(
//                            "$englishWord $dollarCurrencyState $dollarLastWord"
//                        )
//                    )
//                },
//                shape = ShapeDefaults.ExtraLarge,
//                elevation = FloatingActionButtonDefaults.elevation()
//
//            ) {
//                Icon(
//                    painter = painterResource(id = R.drawable.content_copy),
//                    contentDescription = "copy"
//                )
//
//
//            }
//        }

}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    WordsCard(wordString = "")
}
