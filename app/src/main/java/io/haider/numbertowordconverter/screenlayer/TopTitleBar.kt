package io.haider.numbertowordconverter.screenlayer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.haider.numbertowordconverter.R
import io.haider.numbertowordconverter.ui.theme.RuqaaFontFamily

@Composable
fun  TopTitleBar(
    modifier: Modifier=Modifier
) {
    Row(
        modifier = modifier.padding(vertical = 8.dp).fillMaxWidth(),
     //   verticalAlignment = Alignment.CenterVertically,
      //  horizontalArrangement = Arrangement.Start
    ) {
        Text(
            modifier=modifier.padding(start = 16.dp),
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.headlineSmall,
//            minLines = 2,
//            maxLines = 2,
            fontFamily = RuqaaFontFamily,
            overflow = TextOverflow.Ellipsis
        )
//        Box (
//            modifier=modifier.fillMaxWidth(),
//     contentAlignment = Alignment.CenterEnd
//        ){
//            DropDownMenu(modifier = modifier)
//        }

    }
}
//                        Modifier.fillMaxSize().padding(vertical = 8.dp),
//                       // contentAlignment = Alignment.CenterStart
//                    ){
//                        Text(
//                            // modifier = Modifier.padding(8.dp),
//                            text = stringResource(id = R.string.app_name),
//                            style = MaterialTheme.typography.headlineSmall,
//                            minLines = 2,
//                            maxLines = 2,
//                            fontFamily = RuqaaFontFamily,
//                            overflow = TextOverflow.Ellipsis
//                        )
//                    }
//
//
//                },
//                actions = {
//                //    Text(text = "this is text")
//                    Box (
//                        modifier = modifier.padding(8.dp)
//                    ){
//                        DropDownMenu(modifier = modifier)
//                    }
//
//                },
//
@Preview
@Composable
fun TopTitleBarPreview(){
    TopTitleBar()
}