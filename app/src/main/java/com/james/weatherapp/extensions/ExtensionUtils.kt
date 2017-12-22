package com.james.weatherapp.extensions

import java.text.DateFormat
import java.util.*

/**
 * Created by 80575749 on 2017/12/22.
 */

fun Long.toDateString(dateFormat: Int = DateFormat.MEDIUM): String {
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}