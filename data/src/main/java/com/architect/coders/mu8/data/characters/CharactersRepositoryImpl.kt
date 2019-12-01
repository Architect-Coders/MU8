package com.architect.coders.mu8.data.characters

import com.architect.coders.mu8.data.service.MarvelServiceManager
import com.architect.coders.mu8.data.service.MarvelServiceManager.hashcode
import com.architect.coders.mu8.data.utils.MARVEL_PUBLIC_KEY
import com.architect.coders.mu8.data.utils.TIME_STAMP
import com.architect.codes.mu8.characters.Character
import com.architect.codes.mu8.characters.CharactersRepository
import com.architect.codes.mu8.common.Scope

class CharactersRepositoryImpl(
    private val mapper: CharactersMapper
) : CharactersRepository, Scope by Scope.Implementation() {

    init {
        initScope()
    }

    override suspend fun invoke(): List<Character> {
        val response = MarvelServiceManager.service.getAllCharacters(TIME_STAMP, MARVEL_PUBLIC_KEY, hashcode)

        val characters = mutableListOf<Character>()
        if (response.isSuccessful) {
            response.body()?.data?.results?.forEach {
                characters.add(mapper.transform(it))
            }
        }
        return characters
    }
}
