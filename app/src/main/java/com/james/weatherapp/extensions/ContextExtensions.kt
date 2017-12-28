package com.james.weatherapp.extensions

import android.content.Context
import android.support.v4.content.ContextCompat

/**
 * Created by 80575749 on 2017/12/27.
 */

public fun Context.color(res: Int): Int = ContextCompat.getColor(this, res)