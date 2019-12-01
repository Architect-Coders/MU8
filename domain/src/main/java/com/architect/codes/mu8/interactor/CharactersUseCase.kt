package com.architect.codes.mu8.interactor

import com.architect.codes.mu8.characters.Character
import com.architect.codes.mu8.characters.CharactersRepository

interface CharactersUseCase {
    suspend fun getCharacters(): List<Character>
}

class CharactersUseCaseImpl(private val charactersRepository: CharactersRepository) : CharactersUseCase {
    override suspend fun getCharacters(): List<Character> = charactersRepository()
}
