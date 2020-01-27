package com.architect.coders.mu8.data.service

import com.architect.coders.mu8.data.characters.CharactersResponse
import com.architect.coders.mu8.data.comics.ComicResponse
import com.architect.coders.mu8.data.events.EventsResponse
import com.architect.coders.mu8.data.response.BaseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val TIME_STAMP = "ts"
private const val API_KEY = "apikey"
private const val HASH = "hash"
private const val OFFSET = "offset"
private const val LIMIT = "limit"

/**
 * All marvel API Calls requires {@Link [TIME_STAMP]}, {@Link[API_KEY]}, and {@Link [HASH]}
 */
interface MarvelServiceAPI {

    @GET("/v1/public/comics")
    suspend fun getAllComics(
        @Query(TIME_STAMP) timeStamp: String,
        @Query(API_KEY) apiKey: String,
        @Query(HASH) hash: String,
        @Query(OFFSET) offset: Int,
        @Query(LIMIT) limit: Int
    ): Response<BaseResponse<ComicResponse>>

    @GET("/v1/public/characters")
    suspend fun getAllCharacters(
        @Query(TIME_STAMP) timeStamp: String,
        @Query(API_KEY) apiKey: String,
        @Query(HASH) hash: String,
        @Query(OFFSET) offset: Int,
        @Query(LIMIT) limit: Int
    ): Response<BaseResponse<CharactersResponse>>

    @GET("/v1/public/events")
    suspend fun getAllEvents(
        @Query(TIME_STAMP) timeStamp: String,
        @Query(API_KEY) apiKey: String,
        @Query(HASH) hash: String,
        @Query(OFFSET) offset: Int,
        @Query(LIMIT) limit: Int
    ): Response<BaseResponse<EventsResponse>>
}
