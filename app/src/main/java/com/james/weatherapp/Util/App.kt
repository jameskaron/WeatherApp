package com.james.weatherapp.Util

import android.app.Application

/**
 * Created by 80575749 on 2017/11/20.
 */
class App : Application() {
    companion object {
         var instance : Application by DelegatesExt.notNullSingleValue()
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}