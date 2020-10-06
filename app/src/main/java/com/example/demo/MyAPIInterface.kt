package com.example.retrofitsample

import retrofit2.Call
import retrofit2.http.GET




interface MyAPIInterface {
    @GET("weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02")
    fun getWeather(): Call<Data>?


}