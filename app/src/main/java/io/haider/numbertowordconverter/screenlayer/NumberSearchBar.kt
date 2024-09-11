package io.haider.numbertowordconverter.screenlayer

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.haider.numbertowordconverter.ui.theme.NumberToWordConverterTheme

@Composable
fun NumberSearchBar(
    modifier: Modifier=Modifier,
    value:String,
    onValueChange: (String) ->Unit,
    onClick: () ->Unit

){

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            value = value,
            shape = RoundedCornerShape(12.dp),
            onValueChange = onValueChange,
            maxLines = 1,
            textStyle = TextStyle(fontWeight = FontWeight.Bold),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            leadingIcon = { LeadingIconButton(modifier = modifier, onClick = onClick) }
        )
    }
  //  }

@Composable
fun  LeadingIconButton(modifier: Modifier=Modifier, onClick: () -> Unit){
    IconButton(
        modifier=modifier,
        onClick = onClick
    ) {
        Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear")
    }
}
@Preview
@Composable
fun NewDefaultPreview() {
    NumberToWordConverterTheme {
       NumberSearchBar(value = "", onValueChange = {}) {

       }
        // AppSwitches()
    }
}