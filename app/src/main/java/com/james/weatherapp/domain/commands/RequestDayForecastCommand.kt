package com.james.weatherapp.domain.commands

import com.james.weatherapp.domain.datasource.ForecastProvider
import com.james.weatherapp.domain.model.Command
import com.james.weatherapp.domain.model.Forecast

/**
 * Created by 80575749 on 2017/12/20.
 */
class RequestDayForecastCommand (val id: Long,
                                 val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<Forecast> {
        override fun execute() = forecastProvider.requestForecast(id)
}