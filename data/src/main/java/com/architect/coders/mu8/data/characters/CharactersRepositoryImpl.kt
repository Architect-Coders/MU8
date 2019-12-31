package com.architect.coders.mu8.data.characters

import com.architect.coders.mu8.data.DataApp
import com.architect.coders.mu8.data.service.MarvelServiceManager.hashcode
import com.architect.coders.mu8.data.service.MarvelServiceManager.service
import com.architect.coders.mu8.data.utils.DEFAULT_OFFSET
import com.architect.coders.mu8.data.utils.LIMIT
import com.architect.coders.mu8.data.utils.MARVEL_PUBLIC_KEY
import com.architect.coders.mu8.data.utils.TIME_STAMP
import com.architect.codes.mu8.characters.Character
import com.architect.codes.mu8.characters.CharactersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharactersRepositoryImpl(
    private val mapper: CharactersMapper,
    application: DataApp
) : CharactersRepository {

    private val database = application.database

    override suspend fun invoke(): List<Character> = withContext(Dispatchers.IO) {
        with(database.getCharactersDao()) {
            if (charactersCount() <= 0) {
                val response = service.getAllCharacters(
                    TIME_STAMP,
                    MARVEL_PUBLIC_KEY,
                    hashcode,
                    DEFAULT_OFFSET,
                    LIMIT
                )

                if (response.isSuccessful) {
                    response.body()?.data?.results?.run { insertCharacters(this) }
                }
            }
            return@withContext getAllCharacters().map { mapper.transform(it) }
        }
    }
}
