package com.architect.coders.mu8.data.service

import com.architect.coders.mu8.data.characters.CharactersResponse
import com.architect.coders.mu8.data.comics.GetAllComicsResponse
import com.architect.coders.mu8.data.response.BaseResponse
import com.architect.coders.mu8.data.service.MarvelServiceAPI.Companion.API_KEY
import com.architect.coders.mu8.data.service.MarvelServiceAPI.Companion.HASH
import com.architect.coders.mu8.data.service.MarvelServiceAPI.Companion.TIME_STAMP
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * All marvel API Calls requires {@Link [TIME_STAMP]}, {@Link[API_KEY]}, and {@Link [HASH]}
 */
interface MarvelServiceAPI {

    @GET("/v1/public/comics")
    suspend fun getAllComics(
        @Query(TIME_STAMP) timeStamp: String,
        @Query(API_KEY) apiKey: String,
        @Query(HASH) hash: String
    ): Response<GetAllComicsResponse>

    @GET("/v1/public/characters")
    suspend fun getAllCharacters(
        @Query(TIME_STAMP) timeStamp: String,
        @Query(API_KEY) apiKey: String,
        @Query(HASH) hash: String
    ): Response<BaseResponse<CharactersResponse>>

    companion object {
        private const val TIME_STAMP = "ts"
        private const val API_KEY = "apikey"
        private const val HASH = "hash"
    }
}