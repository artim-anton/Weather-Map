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

        mainViewModel.appContext(this)
    }



}

