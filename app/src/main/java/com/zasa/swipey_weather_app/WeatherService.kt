package com.zasa.swipey_weather_app

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 **@Project -> Swipey-Weather-App
 **@Author -> Sangeeth on 9/1/2022
 */
interface WeatherService {

    @GET("current.json")
    fun getCurrentWeather(
        @Query("key") key: String,
        @Query("q") q: String
    ): Call<WeatherResults>

}