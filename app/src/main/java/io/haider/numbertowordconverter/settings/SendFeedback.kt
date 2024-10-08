package io.haider.numbertowordconverter.settings

import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_SEND
import android.net.Uri

//fun navToEmail(): Intent? {
//    val intent = Intent(Intent.ACTION_MAIN)
//    intent.addCategory(Intent.CATEGORY_APP_EMAIL)
//    return Intent.createChooser(intent, "Email")
//}

fun sendToEmail(email: String) = Intent(
    Intent.ACTION_SENDTO,
    Uri.parse("mailto:${email}")
).also {
    Intent.createChooser(it, "Send Feedback")
}

fun appShare(): Intent {
    val sendIntent: Intent = Intent().apply {
        action = ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, "https://github.com/HAIDERALI79/NumberToWordConverter/releases")
        putExtra(Intent.EXTRA_TITLE, "Introducing content previews")
        type = "text/pain"
        //  data = Uri.parse("https://developer.android.com/training/sharing/")
        //  flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
        //   putExtra(Intent.EXTRA_EMAIL, email)
        //  putExtra(Intent, email)

    }
    val shareSheet: Intent = Intent.createChooser(sendIntent, null)
    return shareSheet
}

fun openAppProfile(appUrl: String, context: Context) {
    // Replace with your Twitter profile URL
    val twitterUrl = appUrl

    // Intent to open the Twitter app or a browser
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(twitterUrl))
    context.startActivity(intent)
}