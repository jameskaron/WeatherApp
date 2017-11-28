package com.james.weatherapp

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by james on 2017/11/29.
 */
private class NotNullSingleValueVar<T>() : ReadWriteProperty<Any?, T> {
    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>)
            : T {
        return value ?: throw IllegalStateException("${desc.name} " +
                "not initialized")
    }
    override fun setValue(thisRef: Any?, property: KProperty<*>,
                          value: T) {
        this.value = if (this.value == null) value
        else throw IllegalStateException("${desc.name} already initialized")
    }
}

object DelegatesExt {
    fun <T> notNullSingleValue():
            ReadWriteProperty<Any?, T> = NotNullSingleValueVar()
}