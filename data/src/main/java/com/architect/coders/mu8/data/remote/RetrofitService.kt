package com.architect.coders.mu8.data.remote

import com.architect.coders.mu8.data.remote.RetrofitService.Companion.API_KEY
import com.architect.coders.mu8.data.remote.RetrofitService.Companion.HASH
import com.architect.coders.mu8.data.remote.model.getallComic.GetAllComicsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * All  marvel API Calls requires {@Link TS}, {@Link[API_KEY]}, and {@Link [HASH]}
 */
interface RetrofitService {
    @GET("/v1/public/comics")
    suspend fun getAllComics(
        @Query(TIME_STAMP) timeStamp: String,
        @Query(API_KEY) apiKey: String,
        @Query(HASH) hash: String
    ): Response<GetAllComicsResponse>

    companion object {
        const val TIME_STAMP = "ts"
        const val API_KEY = "apikey"
        const val HASH = "hash"
    }
}