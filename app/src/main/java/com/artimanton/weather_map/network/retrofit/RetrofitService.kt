package com.artimanton.wiki.retrofit

import com.artimanton.weather_map.model.Weather
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.GET




interface RetrofitService {
        @Headers(
                "x-rapidapi-host: community-open-weather-map.p.rapidapi.com",
                "x-rapidapi-key: 90ef3ea0c4mshb022bfcf652d0c2p176274jsn55e19ac37b7e")
        @GET("weather")
        fun getWeather(@Query("q") City: String): Call<Weather?>?

}