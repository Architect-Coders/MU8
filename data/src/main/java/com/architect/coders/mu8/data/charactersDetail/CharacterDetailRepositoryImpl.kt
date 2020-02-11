package com.architect.coders.mu8.data.charactersDetail

import com.architect.coders.mu8.data.DataApp
import com.architect.coders.mu8.data.characters.toDatabaseEntity
import com.architect.coders.mu8.data.characters.toDomainModel
import com.architect.coders.mu8.data.service.MarvelServiceManager.hashcode
import com.architect.coders.mu8.data.service.MarvelServiceManager.service
import com.architect.coders.mu8.data.utils.MARVEL_PUBLIC_KEY
import com.architect.coders.mu8.data.utils.TIME_STAMP
import com.architect.codes.mu8.characters.Character
import com.architect.codes.mu8.charactersDetail.CharacterDetailRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterDetailRepositoryImpl(application: DataApp) : CharacterDetailRepository {

    private val database = application.database

    override suspend fun invoke(id: Long): Character = withContext(Dispatchers.IO){
        with(database.getCharactersDao()) {
            if (charactersCount() <= 0) {
                val response = service.findById(TIME_STAMP, MARVEL_PUBLIC_KEY, hashcode, id)
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