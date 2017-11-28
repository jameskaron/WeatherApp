package com.james.weatherapp

import android.app.Application
import android.database.sqlite.SQLiteOpenHelper
import kotlin.properties.Delegates

/**
 * Created by 80575749 on 2017/11/20.
 */
class App : Application() {
    companion object {
         var instance : Application by Delegates.notNull()
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}