package com.james.weatherapp

import android.app.Application

/**
 * Created by 80575749 on 2017/11/20.
 */
class App : Application() {
    companion object {
        private var instance : Application? = null
        fun instance() = instance!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}