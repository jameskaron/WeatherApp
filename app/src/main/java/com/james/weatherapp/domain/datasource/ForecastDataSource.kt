package com.james.weatherapp.domain.datasource

import com.james.weatherapp.domain.model.ForecastList

/**
 * Created by 80575749 on 2017/12/14.
 */
interface ForecastDataSource {

    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?


}