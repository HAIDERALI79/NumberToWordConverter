package io.haider.numbertowordconverter.screenlayer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun CurrencyNumber(
    modifier: Modifier=Modifier,
    value:String,
    onValueChange: (String) ->Unit,
    onClick: () ->Unit

){
var text by remember {
    mutableStateOf("")
}
    Row(
        Modifier.padding(start = 10.dp, end = 10.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(start = 8.dp)
                //.focusRequester(focusRequester)
//                .clickable(
//                    onClick = {
//                        focusManager.clearFocus()
//                    }
//                )

//                .pointerInput(Unit){
//                detectTapGestures (
//                    onTap = {
//                        focusManager.clearFocus()
//                    }
//                )
//            },
        ) {
            TextField(
                modifier = modifier.padding(end = 8.dp),
                value = value,
                onValueChange =onValueChange,
                maxLines = 2,
               textStyle = TextStyle( fontWeight = FontWeight.Bold),
           keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
              singleLine = true,
//                decorationBox = { innerTextField ->
//                    Row(
//                        Modifier
//                            .background(Color.LightGray, RoundedCornerShape(percent = 30))
//                            .padding(16.dp)
//                            .focusRequester(focusRequester)
//                    ) {
//                        innerTextField()
//                    }
//                }

            )
//            Button(onClick = { focusManager.clearFocus() }) {
//                Text("Clear focus")
//            }
        }
            IconButton(
                onClick = onClick
            ) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Clear")
            }

    }

}
