package com.architect.coders.mu8.data.remote

import com.architect.coders.mu8.data.BuildConfig
import com.architect.coders.mu8.data.remote.RetrofitService.Companion.API_KEY
import com.architect.coders.mu8.data.remote.RetrofitService.Companion.HASH
import com.architect.coders.mu8.data.remote.RetrofitService.Companion.TIME_STAMP
import com.architect.coders.mu8.data.remote.model.getallComic.GetAllComicsResponse
import com.architect.coders.mu8.data.utils.createHashCode
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * All  marvel API Calls requires {@Link [TIME_STAMP]}, {@Link[API_KEY]}, and {@Link [HASH]}
 */
interface RetrofitService {
    @GET("/v1/public/comics")
    suspend fun getAllComics(
        @Query(API_KEY) apiKey: String = BuildConfig.MARVEL_PUBLIC_KEY,
        @Query(HASH) hash: String = createHashCode(),
        @Query(TIME_STAMP) timeStamp: String = BuildConfig.TIME_STAMP
    ): Response<GetAllComicsResponse>

    companion object {
        const val TIME_STAMP = "ts"
        const val API_KEY = "apikey"
        const val HASH = "hash"
    }
}