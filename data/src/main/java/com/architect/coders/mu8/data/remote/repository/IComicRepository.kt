package com.architect.coders.mu8.data.remote.repository

import com.architect.coders.mu8.data.TIME_STAMP
import com.architect.coders.mu8.data.remote.model.getallComic.GetAllComicsResponse
import retrofit2.Response

open interface IComicRepository {
    suspend fun getAllComics(timeStamp: String = TIME_STAMP): Response<GetAllComicsResponse>
}
