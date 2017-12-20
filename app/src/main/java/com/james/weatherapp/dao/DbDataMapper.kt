package com.james.weatherapp.dao

import com.james.weatherapp.domain.model.CityForecast
import com.james.weatherapp.domain.model.DayForecast
import com.james.weatherapp.domain.model.Forecast
import com.james.weatherapp.domain.model.ForecastList

/**
 * Created by 80575749 on 2017/12/8.
 */
class DbDataMapper {
    fun convertToDomain(forecast: CityForecast) = with(forecast) {
        val daily = dailyForecast.map { convertDayToDomain(it) }
        ForecastList(_id, city, country, daily)
    }
    fun convertDayToDomain(dayForecast: DayForecast) = with(dayForecast) {
        Forecast(_id, date, description, high, low, iconUrl)
    }

    fun convertFromDomain(forecast: ForecastList) = with(forecast) {
        val daily = dailyForecast.map {
            convertDayFromDomain(id, it)
        }
        CityForecast(id, city, country, daily)
    }

    private fun convertDayFromDomain(cityId: Long, forecast: Forecast
    ) = with(forecast) {
        DayForecast(date, description, high, low, iconUrl, cityId)
    }
}