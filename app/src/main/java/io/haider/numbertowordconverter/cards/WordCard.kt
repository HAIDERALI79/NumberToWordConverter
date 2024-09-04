package io.haider.numbertowordconverter.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.haider.numbertowordconverter.R

@Composable
fun WordsCard(
    modifier: Modifier = Modifier,
    wordString: String,
) {
    val colorScheme = MaterialTheme.colorScheme
    val clipboardManager: ClipboardManager = LocalClipboardManager.current
    val context = LocalContext.current
    //  val wordString = "$arabicWord $dinarCurrencyState $dinarLastWord"

    Card(
        modifier = modifier.padding(horizontal = 16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant
        )
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp),
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
                Row {

                    IconButton(
                        modifier = modifier.clip(CircleShape),
                        onClick = {
//                        context.startActivity(
//                shareSheet(text= wordString))

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

                    IconButton(
                        modifier = modifier.clip(CircleShape),
                        onClick = {
                            context.startActivity(
                                shareSheet(text = wordString)
                            )

//                        clipboardManager.setText(
//                            annotatedString = AnnotatedString(
//                                wordString
//                            )
//                        )
                        },

                        ) {
                        Icon(
                            painter = painterResource(id = R.drawable.share_content),
                            contentDescription = "copy"
                        )


                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    WordsCard(wordString = "this is test")
}





