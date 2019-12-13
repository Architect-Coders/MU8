package com.architect.coders.mu8.data.service

import com.architect.coders.mu8.data.BuildConfig.BASE_URL
import com.architect.coders.mu8.data.utils.createHashCode
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MarvelServiceManager {

    val hashcode = createHashCode()

    private val okHttpClient = HttpLoggingInterceptor().run {
        level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient
            .Builder()
            .addInterceptor(this)
            .build()
    }

    val service = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .run { create(MarvelServiceAPI::class.java) }
}
