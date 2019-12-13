package com.architect.codes.mu8.characters

interface CharactersUseCase {
    suspend fun getCharacters(): List<Character>
}

class CharactersUseCaseImpl(private val charactersRepository: CharactersRepository) :
    CharactersUseCase {
    override suspend fun getCharacters(): List<Character> = charactersRepository()
}
