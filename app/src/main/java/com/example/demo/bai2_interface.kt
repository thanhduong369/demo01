package com.example.demo

import retrofit2.Call
import retrofit2.http.GET

interface bai2_interface {
      @GET("api/v1/employees")
    fun  getdateduong(): Call<bai2data>?
}