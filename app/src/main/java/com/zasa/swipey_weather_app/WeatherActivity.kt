package com.zasa.swipey_weather_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_weather.*

class WeatherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val bundle : Bundle? = intent.extras

        val location = bundle!!.getString("location")
        val tempInCelsius = bundle.getString("tempInCelsius")
        tvLocation.text = location
        tvTempInCelcius.text = tempInCelsius
    }
}