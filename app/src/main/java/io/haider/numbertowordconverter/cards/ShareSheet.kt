package io.haider.numbertowordconverter.cards

import android.content.Intent
import android.content.Intent.ACTION_SEND


fun shareSheet(text: String): Intent {
    val sendIntent: Intent = Intent().apply {
        action = ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, text)
        type = "text/pain"

    }
    val shareSheet: Intent = Intent.createChooser(sendIntent, "text")
    return shareSheet

}

