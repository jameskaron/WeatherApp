package com.james.weatherapp.domain

/**
 * Created by 80575749 on 2017/10/23.
 */
public interface Command<T> {
    fun execute(): T


}

data class ForecastList(val city: String, val country: String,
                        val dailyForecast:List<Forecast>){
    operator fun get(position:Int): Forecast = dailyForecast[position]
    fun size (): Int = dailyForecast.size

}

data class Forecast(val date: String, val description: String, val high: Int,
                    val low: Int)