package com.james.weatherapp.data

import android.util.Log
import java.net.URL

/**
 * Created by james on 2017/10/5.
 */
class Request (val url : String){
    public fun run(){
        val forecastJsonStr = URL(url).readText();
        Log.d(javaClass.simpleName,forecastJsonStr);
    }
}