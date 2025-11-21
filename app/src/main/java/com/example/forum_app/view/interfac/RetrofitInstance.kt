package com.example.forum_app.view

import com.example.forum_app.view.interfac.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance
{
    private const val base_url="https://jsonplaceholder.typicode.com/"
    val api: ApiService by lazy{
        Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

    }
}