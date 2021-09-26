package com.artimanton.weather_map.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.artimanton.weather_map.Repository
import com.artimanton.weather_map.model.Weather
import androidx.databinding.ObservableField

class MainViewModel : ViewModel() {
    private val myRepository = Repository
    val editTextContent = MutableLiveData<String>()
    val liveData = MutableLiveData<Weather>()
    var resultImageUrl = ObservableField<String>()


    fun callApi() {
        editTextContent.value?.let { myRepository.callMyRetrofitApi(liveData, it) }
    }

   fun imageUrlUpdated(url: String){
       //val imgUrl = "http://openweathermap.org/img/wn/$url@2x.png"
        resultImageUrl.set(url)
    }


}