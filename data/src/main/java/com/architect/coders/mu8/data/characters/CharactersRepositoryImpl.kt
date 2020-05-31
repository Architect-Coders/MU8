package com.architect.coders.mu8.data.characters

import com.architect.coders.mu8.data.DataApp
import com.architect.coders.mu8.data.service.MarvelServiceManager
import com.architect.coders.mu8.data.utils.DEFAULT_OFFSET
import com.architect.coders.mu8.data.utils.LIMIT
import com.architect.coders.mu8.data.utils.MARVEL_PUBLIC_KEY
import com.architect.coders.mu8.data.utils.TIME_STAMP
import com.architect.codes.mu8.characters.Character
import com.architect.codes.mu8.characters.CharactersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharactersRepositoryImpl(application: DataApp, private val manager: MarvelServiceManager) : CharactersRepository {

    private val database = application.database

    override suspend fun invoke(): List<Character> = withContext(Dispatchers.IO) {
        with(database.getCharactersDao()) {
            if (charactersCount() <= 0) {
                val response = manager.service.getAllCharacters(TIME_STAMP, MARVEL_PUBLIC_KEY, manager.hashcode, DEFAULT_OFFSET, LIMIT)
                if (response.isSuccessful) {
                    response.body()?.data?.results?.run {
                        map { it.toDatabaseEntity() }.also { insertCharacters(it) }
                    }
                }
            }
            return@withContext getAllCharacters().map { it.toDomainModel() }
        }
    }

    override suspend fun findCharacter(id: Long): Character = withContext(Dispatchers.IO) {
        with(database.getCharactersDao()) {
            if (charactersCount() <= 0) {
                val response = manager.service.findCharacterById(TIME_STAMP, MARVEL_PUBLIC_KEY, manager.hashcode, id)
                if (response.isSuccessful) {
                    response.body()?.data?.results?.run {
                        map { it.toDatabaseEntity() }.also { insertCharacters(it) }
                    }
                }
            }
            return@withContext findbyId(id).toDomainModel()
        }
    }
}
