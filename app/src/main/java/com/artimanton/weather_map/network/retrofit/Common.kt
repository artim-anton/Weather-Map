package com.artimanton.wiki.retrofit


object Common {
    private val BASE_URL = "https://community-open-weather-map.p.rapidapi.com/"
    val retrofitService: RetrofitService
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
}