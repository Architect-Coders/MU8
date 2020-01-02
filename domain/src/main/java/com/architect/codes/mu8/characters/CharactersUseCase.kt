package com.architect.codes.mu8.characters

interface CharactersUseCase {
    suspend operator fun invoke(): List<Character>
}

class CharactersUseCaseImpl(
    private val charactersRepository: CharactersRepository
) : CharactersUseCase {
    override suspend operator fun invoke(): List<Character> = charactersRepository()
}
