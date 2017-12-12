package com.james.weatherapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.james.weatherapp.Adapter.ForecastListAdapter
import com.james.weatherapp.domain.commands.RequestForecastCommand
import org.jetbrains.anko.*
import kotlinx.android.synthetic.main.activity_main.*;

class MainActivity : AppCompatActivity() {

    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        forecastList.layoutManager = LinearLayoutManager(this)

        doAsync {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
//                forecastList.adapter = ForecastListAdapter(result){forecast -> toast(forecast.date) }
                  val adapter = ForecastListAdapter(result){toast(it.date) }
            }
        }

    }
}
