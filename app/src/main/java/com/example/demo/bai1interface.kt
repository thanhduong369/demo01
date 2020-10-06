package com.example.demo

import retrofit2.http.GET
import  retrofit2.Call
interface bai1interface {
    @GET("todos/1")
    fun  getdate(): Call<bai1_data>?
}