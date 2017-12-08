package com.james.weatherapp.domain.model

/**
 * Created by 80575749 on 2017/10/23.
 */
public interface Command<T> {
    fun execute(): T


}
//use to show on UI
data class ForecastList(val id: Long, val city: String, val country: String,
                        val dailyForecast: List<Forecast>){
    operator fun get(position:Int) = dailyForecast[position]
    fun size () = dailyForecast.size

}

data class Forecast(val id: Long, val date: Long, val description: String, val high: Int, val low: Int,
                    val iconUrl: String)