package com.james.weatherapp.domain.datasource

import com.james.weatherapp.dao.ForecastDb
import com.james.weatherapp.data.server.ForecastServer
import com.james.weatherapp.domain.model.Forecast
import com.james.weatherapp.domain.model.ForecastList
import com.james.weatherapp.extensions.firstResult

/**
 * Created by 80575749 on 2017/12/14.
 */
class ForecastProvider(private val sources: List<ForecastDataSource> = ForecastProvider.SOURCES) {

    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
        val SOURCES by lazy { listOf(ForecastDb(), ForecastServer()) }
    }

    fun requestByZipCode(zipCode: Long, days: Int): ForecastList = requestToSources {
        val res = it.requestForecastByZipCode(zipCode, todayTimeSpan())
        if (res != null && res.size() >= days) res else null
    }

    fun requestForecast(id: Long): Forecast = requestToSources {
        it.requestDayForecast(id)
    }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS

    private fun <T : Any> requestToSources(f: (ForecastDataSource) -> T?): T= sources.firstResult { f(it) }
}