package com.artimanton.wiki.retrofit


object Common {
    private val BASE_URL = "https://community-open-weather-map.p.rapidapi.com/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}