package com.example.demo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class bai2_activity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val BASE_URL = "http://dummy.restapiexample.com/"

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()

        val myRetrofitAPI: bai2_interface = retrofit.create<bai2_interface>(
            bai2_interface::class.java
        )
        myRetrofitAPI.getdateduong()?.enqueue(object : Callback<bai2data> {
            override fun onFailure(call: Call<bai2data>, t: Throwable) {
                Log.d("API call","error")
            }
            override fun onResponse(
                call: Call<bai2data>?, response: Response<bai2data>?
            ) {
                Log.d("API call","success")
                if(response?.isSuccessful?:false){
                    response?.let {
                        Log.d("API call value", response!!.body().status?:"")
                        Log.d("API call value", response!!.body().message?:"")
                    }
                }else{

                }
            }
        })
    }
}