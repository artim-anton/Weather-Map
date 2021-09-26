package com.artimanton.weather_map.viewModel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.artimanton.weather_map.network.Repository
import com.artimanton.weather_map.model.Weather
import androidx.databinding.ObservableField
import com.artimanton.weather_map.R
import com.artimanton.weather_map.network.isNetworkAvailable

class MainViewModel() : ViewModel() {
    val myRepository = Repository
    val editTextContent = MutableLiveData<String>()
    val liveData = MutableLiveData<Weather>()
    var resultImageUrl = ObservableField<String>()
    lateinit var context: Context

    fun appContext(context: Context){
        this.context = context
    }

    fun callApi() {
        if(isNetworkAvailable(context)) {
            editTextContent.value?.let { myRepository.callMyRetrofitApi(liveData, it) }
        }else{
            Toast.makeText(context, context.getString(R.string.check_internet_con), Toast.LENGTH_SHORT).show()
        }
    }

   fun imageUrlUpdated(url: String){
        resultImageUrl.set(url)
    }


}