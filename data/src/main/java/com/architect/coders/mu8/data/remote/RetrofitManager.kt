package com.architect.coders.mu8.data.remote

import com.architect.coders.mu8.data.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitManager {

    private val service: RetrofitService

    init {
        val builder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
        val retrofit = builder.build()
        service = retrofit.create(RetrofitService::class.java)
    }

    fun getService() = service

    companion object {
        const val BASE_URL = BuildConfig.API_BASE_URL
    }
}