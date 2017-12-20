package com.james.weatherapp.data.server

import com.james.weatherapp.dao.ForecastDb
import com.james.weatherapp.data.ForecastByZipCodeRequest
import com.james.weatherapp.domain.datasource.ForecastDataSource
import com.james.weatherapp.domain.model.Forecast
import com.james.weatherapp.domain.model.ForecastList

/**
 * Created by 80575749 on 2017/12/15.
 */
class ForecastServer(val dataMapper: ServerDataMapper = ServerDataMapper(), val forecastDb: ForecastDb = ForecastDb()) : ForecastDataSource {

    override fun requestForecastByZipCode(zipCode: Long, date: Long):
            ForecastList? {
        val result = ForecastByZipCodeRequest(zipCode).execute()
        val converted = dataMapper.convertToDomain(zipCode, result)
        forecastDb.saveForecast(converted)
        return forecastDb.requestForecastByZipCode(zipCode, date)
    }

    override fun requestDayForecast(id: Long): Forecast? = throw UnsupportedOperationException()
}