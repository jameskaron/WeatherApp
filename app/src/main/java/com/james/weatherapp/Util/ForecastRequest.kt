package com.james.weatherapp.Util

import com.google.gson.Gson

/**
 * Created by james on 2017/10/20.
 */
class ForecastRequest(val zipCode: String) {
    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/" + "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    fun execute(): ForecastRequest{
        val forecastJsonStr = java.net.URL(COMPLETE_URL + zipCode).readText()
        return Gson().fromJson(forecastJsonStr,ForecastRequest::class.java)
    }
}