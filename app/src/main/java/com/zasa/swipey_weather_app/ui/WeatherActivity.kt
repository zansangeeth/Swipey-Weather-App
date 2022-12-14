package com.zasa.swipey_weather_app.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zasa.swipey_weather_app.R
import kotlinx.android.synthetic.main.activity_weather.*

class WeatherActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val bundle: Bundle? = intent.extras

        val location = bundle!!.getString("location")
        val country = bundle.getString("country")
        val tempInCelsius = bundle.getString("tempInCelsius")
        val currentCondition = bundle.getString("currentCondition")
        val windMph = bundle.getString("windMph")
        val humidity = bundle.getString("humidity")

        tvLocationName.text = "$location,  "
        tvCountryName.text = country
        tvTemperature.text = "$tempInCelsius °C"
        tvCondition.text = currentCondition
        tvWind.text = "$windMph Mph"
        tvHumidity.text = humidity

    }
}