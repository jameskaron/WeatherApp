package com.james.weatherapp.dao

import com.james.weatherapp.R
import com.james.weatherapp.R.id.date
import com.james.weatherapp.domain.datasource.ForecastDataSource
import com.james.weatherapp.domain.model.*
import com.james.weatherapp.extensions.*
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.SelectQueryBuilder
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

/**
 * Created by 80575749 on 2017/12/7.
 */
class ForecastDb(val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance,
                 val dataMapper: DbDataMapper = DbDataMapper()) : ForecastDataSource{



    override fun requestForecastByZipCode(zipCode: Long, date: Long) = forecastDbHelper.use {
        val dailyRequest = "${DayForecastTable.CITY_ID} = ? " + "AND ${DayForecastTable.DATE} >= ?"
        val dailyForecast = select(DayForecastTable.NAME).whereSimple(dailyRequest, zipCode.toString(), date.toString())
                        .parseList { DayForecast(HashMap(it)) }

        val city = select(CityForecastTable.NAME).whereSimple("${CityForecastTable.ID} = ?", zipCode.toString())
                .parseOpt { CityForecast(HashMap(it), dailyForecast) }

        if (city != null) dataMapper.convertToDomain(city) else null
    }

    override fun requestDayForecast(id: Long) =  forecastDbHelper.use {
        val forecast = select(DayForecastTable.NAME).byId(id).parseOpt{DayForecast(HashMap(it))}

        forecast?.let { dataMapper.convertDayToDomain(it) }
    }
    fun saveForecast(forecast: ForecastList) = forecastDbHelper.use {
        clear(CityForecastTable.NAME)
        clear(DayForecastTable.NAME)

        with(dataMapper.convertFromDomain(forecast)) {
            insert(CityForecastTable.NAME, *map.toVarargArray())
            dailyForecast.forEach {
                insert(DayForecastTable.NAME, *it.map.toVarargArray())
            }
        }
    }

}