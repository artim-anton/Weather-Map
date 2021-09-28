package com.artimanton.weather_map.network

import androidx.lifecycle.MutableLiveData
import com.artimanton.weather_map.model.Weather
import com.artimanton.wiki.retrofit.Common
import com.artimanton.wiki.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



object Repository {
    private var mService: RetrofitService = Common.retrofitService
    fun loadWeather(liveData: MutableLiveData<Weather>, city:String) {
        mService.getWeather(city)?.enqueue( object : Callback<Weather?> {
            override fun onFailure(call: Call<Weather?>, t: Throwable) {

            }

            override fun onResponse(call: Call<Weather?>, response: Response<Weather?>) {
                liveData.value = response.body()
            }
        })
    }

}