package com.architect.coders.mu8.data.service

import com.architect.coders.mu8.data.utils.createHashCode
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MarvelServiceManager(baseUrl: String) {

    val hashcode: String
        get() = createHashCode()

    val service: MarvelServiceAPI = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .run { create(MarvelServiceAPI::class.java) }

    val okHttpClient: OkHttpClient
        get() = HttpLoggingInterceptor().run {
            level = HttpLoggingInterceptor.Level.BODY
            OkHttpClient
                .Builder()
                .addInterceptor(this)
                .build()
        }
}
