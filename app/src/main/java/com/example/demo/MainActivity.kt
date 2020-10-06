package com.example.demo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitsample.Data
import com.example.retrofitsample.MyAPIInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val BASE_URL = "https://samples.openweathermap.org/data/2.5/"

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()

        val myRetrofitAPI: MyAPIInterface = retrofit.create<MyAPIInterface>(
                MyAPIInterface::class.java
        )

        myRetrofitAPI.getWeather()?.enqueue(object : Callback<Data> {

            override fun onFailure(call: Call<Data>, t: Throwable) {
                Log.d("API call","error")
            }

            override fun onResponse(
                    call: Call<Data>?, response: Response<Data>?
            ) {
                Log.d("API call","success")
                if(response?.isSuccessful?:false){
                    response?.let {
                        Log.d("API call value", response!!.body().name?:"")
                        Log.d("API call value", response!!.body()!!.weather?.get(0)!!.description?:"")
                        Log.d("xxxxx",response.body().id.toString())
                    }
                }else{

                }
            }
        })
    }
}