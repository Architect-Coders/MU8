package com.architect.coders.mu8.data.comics

import com.architect.coders.mu8.data.DataApp
import com.architect.coders.mu8.data.service.MarvelServiceManager
import com.architect.coders.mu8.data.service.MarvelServiceManager.service
import com.architect.coders.mu8.data.utils.DEFAULT_OFFSET
import com.architect.coders.mu8.data.utils.LIMIT
import com.architect.coders.mu8.data.utils.MARVEL_PUBLIC_KEY
import com.architect.coders.mu8.data.utils.TIME_STAMP
import com.architect.codes.mu8.callback.ComicRepository
import com.architect.codes.mu8.comics.Comic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ComicRepositoryImpl(application: DataApp) : ComicRepository {

    private val database = application.database

    override suspend fun invoke(): List<Comic> = withContext(Dispatchers.IO) {
        with(database.getComicsDao()) {
            val isComicsTableEmpty = comicsCount() <= 0
            if (isComicsTableEmpty) {
                val response = service.getAllComics(
                    TIME_STAMP,
                    MARVEL_PUBLIC_KEY,
                    MarvelServiceManager.hashcode,
                    DEFAULT_OFFSET,
                    LIMIT
                )

                if (response.isSuccessful) {
                    response.body()?.data?.results?.run {
                        map { it.toDatabaseEntity() }.also { comicsEntityList ->
                            insertComics(comicsEntityList as List<ComicsEntity>)
                        }
                    }
                }
            }
            return@withContext getAllComics().map { it.toDomainModel() }
        }
    }
}