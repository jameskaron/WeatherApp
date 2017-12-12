package com.james.weatherapp.extensions

/**
 * Created by 80575749 on 2017/12/12.
 */

fun <K, V : Any> MutableMap<K, V?>.toVarargArray():
        Array<out Pair<K, V>> = map({ Pair(it.key, it.value!!) }).toTypedArray()