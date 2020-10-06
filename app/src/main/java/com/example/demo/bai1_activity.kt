package com.example.demo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.bai1.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class bai1_activity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bai1)

        val BASE_URL = "https://jsonplaceholder.typicode.com/"

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()

        val myRetrofitAPI: bai1interface = retrofit.create<bai1interface>(
            bai1interface::class.java
        )

        myRetrofitAPI.getdate()?.enqueue(object : Callback<bai1_data> {

            override fun onFailure(call: Call<bai1_data>, t: Throwable) {
                Log.d("API call","error")
            }
            override fun onResponse(
                call: Call<bai1_data>?, response: Response<bai1_data>?
            ) {
                Log.d("API call","success")
                if(response?.isSuccessful?:false){
                    response?.let {
                        id.text ="id :"+response!!.body().id.toString()
                        userid.text ="user id :"+response!!.body().userId.toString()
                        xxtitle.text ="title :"+response!!.body().title.toString()
                        complete.text ="complete:"+response!!.body().completed.toString()
                    }
                }else{

                }
            }
        })
    }
}