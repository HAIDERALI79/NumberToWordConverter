package io.haider.numbertowordconverter.appdata

object TextInputCheck{
    fun String?.isPosOrNegNumber(): Boolean {
        val regex = """^(-)?[0-9]*((\.)[0-9]+)?$""".toRegex()
        return if (this.isNullOrEmpty()) false
        else regex.matches(this)
    }
}
