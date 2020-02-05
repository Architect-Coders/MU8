package com.architect.codes.mu8.charactersDetail

import com.architect.codes.mu8.characters.Character
import com.architect.codes.mu8.characters.CharactersRepository

interface CharacterDetailUseCase {
    suspend operator fun invoke() : Character
}

class CharacterDetalUseCaseImpl(
    private val characterDetailRepository: CharacterDetailRepository
) : CharacterDetailUseCase {
    override suspend fun invoke(): Character = characterDetailRepository()
}

