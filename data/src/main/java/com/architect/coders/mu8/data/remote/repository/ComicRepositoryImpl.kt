package com.architect.coders.mu8.data.remote.repository

import com.architect.coders.mu8.data.remote.RetrofitManager
import com.architect.coders.mu8.data.remote.mapper.ComicMapper
import com.architect.codes.mu8.callback.ComicRepository
import com.architect.codes.mu8.model.Comic

class ComicRepositoryImpl(private val mapper: ComicMapper = ComicMapper()) : ComicRepository {
    
    private val retrofitManager = RetrofitManager()
    private val service = retrofitManager.getService()

    override suspend fun getAllComics(): List<Comic> {
        val response = service.getAllComics()

        response.body()?.apply {
            return data.results.map { comicResponse -> mapper.transform(comicResponse) }
        }
        return listOf()
    }
}