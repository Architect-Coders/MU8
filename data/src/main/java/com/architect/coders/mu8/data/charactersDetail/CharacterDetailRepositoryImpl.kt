package com.architect.coders.mu8.data.charactersDetail

import com.architect.coders.mu8.data.DataApp
import com.architect.coders.mu8.data.comics.toDatabaseEntity
import com.architect.coders.mu8.data.comics.toDomainModel
import com.architect.coders.mu8.data.service.MarvelServiceManager.hashcode
import com.architect.coders.mu8.data.service.MarvelServiceManager.service
import com.architect.coders.mu8.data.utils.DEFAULT_OFFSET
import com.architect.coders.mu8.data.utils.LIMIT
import com.architect.coders.mu8.data.utils.MARVEL_PUBLIC_KEY
import com.architect.coders.mu8.data.utils.TIME_STAMP
import com.architect.codes.mu8.characters.detail.CharacterDetailRepository
import com.architect.codes.mu8.comics.Comic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterDetailRepositoryImpl(application: DataApp) : CharacterDetailRepository {

    private val database = application.database

    override suspend fun getComicsForCharacter(id: Long, idComics: List<String>): List<Comic> = withContext(Dispatchers.IO) {
        with(database.getComicsDao()) {
            var characterComics = getListComicCharacter(idComics).map { it.toDomainModel() }
            if (characterComics.isEmpty()) {
                val response = service.getComicsForCharacter(
                    id, TIME_STAMP, MARVEL_PUBLIC_KEY, hashcode, DEFAULT_OFFSET, LIMIT
                )
                if (response.isSuccessful) {
                    response.body()?.data?.results?.run {
                        map { it.toDatabaseEntity() }
                            .also { list ->
                                insertComics(list)
                                list.forEach {
                                    (characterComics as MutableList<Comic>).add(it.toDomainModel())
                                }
                            }
                    }
                }
            }
            return@withContext characterComics
        }
    }
}
