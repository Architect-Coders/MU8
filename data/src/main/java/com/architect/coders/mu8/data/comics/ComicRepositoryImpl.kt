package com.architect.coders.mu8.data.comics

import com.architect.coders.mu8.data.service.MarvelServiceManager
import com.architect.coders.mu8.data.utils.MARVEL_PUBLIC_KEY
import com.architect.coders.mu8.data.utils.TIME_STAMP
import com.architect.codes.mu8.callback.ComicRepository
import com.architect.codes.mu8.comics.Comic

class ComicRepositoryImpl(private val mapper: ComicsMapper) : ComicRepository {

    override suspend fun invoke(): List<Comic> {
        val response = MarvelServiceManager.service
            .getAllComics(TIME_STAMP, MARVEL_PUBLIC_KEY, MarvelServiceManager.hashcode)

        response.body()?.apply {
            return data.results.map { comicResponse -> mapper.transform(comicResponse) }
        }
        return listOf()
    }
}