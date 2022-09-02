package com.zasa.swipey_weather_app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.zasa.swipey_weather_app.R
import com.zasa.swipey_weather_app.response.WeatherResults
import com.zasa.swipey_weather_app.utils.Constants.API_KEY
import com.zasa.swipey_weather_app.utils.Constants.BASE_URL
import com.zasa.swipey_weather_app.api.WeatherService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.HTTP

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultsButton = findViewById<Button>(R.id.btnShowResults)


        // The Retrofit class generates an implementation of the WeatherService interface.
        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()

        val weatherService = retrofit.create(WeatherService::class.java)

        resultsButton.setOnClickListener {
            val location = etLocation.text.toString()

            // null or empty string checking for text field
            if (location.equals(null) || location == "") {
                textField.error = "Location cannot be null"
            } else

                //Each Call from the created WeatherService can make a synchronous or asynchronous HTTP request to the remote webserver.
                weatherService.getCurrentWeather("$API_KEY", "$location")
                        .enqueue(object : Callback<WeatherResults> {
                            override fun onResponse(
                                call: Call<WeatherResults>,
                                response: Response<WeatherResults>
                            ) {
                                if (!response.isSuccessful) {
                                    startActivity(Intent(this@MainActivity, ErrorActivity::class.java))
                                } else {
                                    val body = response.body()
                                    Log.i(TAG, "Response : $body")
                                    val weatherIntent =
                                        Intent(this@MainActivity, WeatherActivity::class.java)
                                        weatherIntent.putExtra("location", body!!.location.name)
                                        weatherIntent.putExtra("country", body.location.country)
                                        weatherIntent.putExtra(
                                            "tempInCelsius",
                                            body.current.temp_c.toString()
                                    )
                                        weatherIntent.putExtra(
                                            "currentCondition",
                                            body.current.condition.text
                                    )
                                        weatherIntent.putExtra("windMph", body.current.wind_mph.toString())
                                        weatherIntent.putExtra("humidity", body.current.humidity.toString())

                                    startActivity(weatherIntent)
                                }

                            }
                            override fun onFailure(call: Call<WeatherResults>, t: Throwable) {
                                Log.i(TAG, "error : $t")
                            }
                        })
        }

    }
}