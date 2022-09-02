package com.zasa.swipey_weather_app.response

import com.zasa.swipey_weather_app.response.Current
import com.zasa.swipey_weather_app.response.Location

data class WeatherResults(
    val current: Current,
    val location: Location
)