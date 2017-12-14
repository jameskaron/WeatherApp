package com.james.weatherapp.domain.datasource

import com.james.weatherapp.dao.ForecastDb
import com.james.weatherapp.domain.model.ForecastList
import com.james.weatherapp.extensions.firstResult

/**
 * Created by 80575749 on 2017/12/14.
 */
class ForecastProvider(val sources: List<ForecastDataSource> = ForecastProvider.SOURCES) {

    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES = listOf(ForecastDb(), ForecastServer())
    }

    fun requestByZipCode(zipCode: Long, days: Int): ForecastList = sources.firstResult { requestSource(it, days, zipCode) }

}