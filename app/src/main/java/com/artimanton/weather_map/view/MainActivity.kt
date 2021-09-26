package com.artimanton.weather_map.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.artimanton.weather_map.viewModel.MainViewModel
import com.artimanton.weather_map.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val mainViewModel by lazy{
        return@lazy ViewModelProvider(this).get(MainViewModel::class.java)}
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.artimanton.weather_map.R.layout.activity_main)

        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, com.artimanton.weather_map.R.layout.activity_main).apply {
            this.setLifecycleOwner(this@MainActivity)
            this.viewmodel = mainViewModel
        }


        mainViewModel.callApi()
        //mainViewModel.imageUrlUpdated("http://openweathermap.org/img/wn/04d@2x.png")
        observeResponseData()
    }

    private fun observeResponseData() {

        mainViewModel.liveData.observe(this, Observer { data ->
            mainViewModel.imageUrlUpdated("http://openweathermap.org/img/wn/"+data.weather[0].icon+"@2x.png")
        })
    }



}

