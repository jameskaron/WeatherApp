package com.james.weatherapp.domain.commands

import com.james.weatherapp.domain.datasource.ForecastProvider
import com.james.weatherapp.domain.model.Command
import com.james.weatherapp.domain.model.ForecastList

/**
 * Created by 80575749 on 2017/10/23.
 */
class RequestForecastCommand(val zipCode: Long, val forecastProvider: ForecastProvider = ForecastProvider())
                            : Command<ForecastList> {
    companion object {
        val DAYS = 7
    }

    override fun execute(): ForecastList {
        return forecastProvider.requestByZipCode(zipCode, DAYS)
    }
}