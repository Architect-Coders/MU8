package com.architect.codes.mu8.characters

interface CharactersUseCase {
    suspend operator fun invoke(): List<Character>
    suspend fun findCharacter(id: Long): Character
}

class CharactersUseCaseImpl(
    private val charactersRepository: CharactersRepository
) : CharactersUseCase {

    override suspend operator fun invoke(): List<Character> = charactersRepository()

    override suspend fun findCharacter(id: Long): Character = charactersRepository.findCharacter(id)
}
