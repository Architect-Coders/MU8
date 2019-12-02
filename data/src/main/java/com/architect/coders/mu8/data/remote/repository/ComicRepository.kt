package com.architect.coders.mu8.data.remote.repository

import com.architect.coders.mu8.data.remote.RetrofitManager
import com.architect.coders.mu8.data.remote.mapper.ComicMapper
import com.architect.codes.mu8.callback.IComicRepository
import com.architect.codes.mu8.model.Comic

class ComicRepository(private val mapper: ComicMapper = ComicMapper()) : IComicRepository {
    private val retrofitManager = RetrofitManager()
    private val service = retrofitManager.getService()

    override suspend fun getAllComics(): List<Comic> {
        val response = service.getAllComics()
        response.body()?.apply {
            return data.results.map { comicR -> mapper.transform(comicR) }
        }
        return listOf()
    }

}