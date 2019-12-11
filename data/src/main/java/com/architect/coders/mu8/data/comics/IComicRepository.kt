package com.architect.coders.mu8.data.comics

import com.architect.coders.mu8.data.utils.TIME_STAMP
import retrofit2.Response

interface IComicRepository {
    suspend fun getAllComics(timeStamp: String = TIME_STAMP): Response<GetAllComicsResponse>
}
