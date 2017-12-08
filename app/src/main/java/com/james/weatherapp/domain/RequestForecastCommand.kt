package com.james.weatherapp.domain

import com.james.weatherapp.Util.ForecastRequest
import com.james.weatherapp.domain.model.Command
import com.james.weatherapp.domain.model.ForecastList

/**
 * Created by 80575749 on 2017/10/23.
 */
class RequestForecastCommand(private val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }


}