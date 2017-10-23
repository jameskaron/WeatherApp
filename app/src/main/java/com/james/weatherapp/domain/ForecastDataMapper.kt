package com.james.weatherapp.domain

import com.james.weatherapp.Data.Forecast
import com.james.weatherapp.Data.ForecastResult
import com.james.weatherapp.Util.ForecastRequest
import java.text.DateFormat
import java.util.*
import com.james.weatherapp.domain.Forecast as ModelForecast

/**
 * Created by 80575749 on 2017/10/23.
 */
class ForecastDataMapper {

    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }
    private fun convertForecastListToDomain(list: List<Forecast>):
            List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }
    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt),
                forecast.weather[0].description, forecast.temp.max.toInt(),
                forecast.temp.min.toInt())
    }
    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }

}
