package com.zasa.swipey_weather_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.zasa.swipey_weather_app.Constants.API_KEY
import com.zasa.swipey_weather_app.Constants.BASE_URL
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultsButton = findViewById<Button>(R.id.btnShowResults)
//        val currrentWeather = mutableListOf<Current>()

        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()

        val weatherService = retrofit.create(WeatherService::class.java)

        resultsButton.setOnClickListener {
            val location = etLocation.text.toString()

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
                            weatherIntent.putExtra("tempInCelsius", body.current.temp_c.toString())
                            weatherIntent.putExtra("currentCondition", body.current.condition.text)
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