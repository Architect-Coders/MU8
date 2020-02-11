package com.architect.codes.mu8.charactersDetail

import com.architect.codes.mu8.characters.Character

interface CharacterDetailUseCase {
    suspend operator fun invoke(id: Long): Character
}

class CharacterDetalUseCaseImpl(
    private val characterDetailRepository: CharacterDetailRepository
) : CharacterDetailUseCase {
    override suspend fun invoke(id: Long): Character = characterDetailRepository.invoke(id)
}