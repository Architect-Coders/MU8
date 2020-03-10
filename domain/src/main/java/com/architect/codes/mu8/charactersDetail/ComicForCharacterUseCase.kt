package com.architect.codes.mu8.charactersDetail

import com.architect.codes.mu8.comics.Comic

interface CharacterDetailUseCase {
    suspend fun getComicsForCharacter(id: Long, idComics: List<String>): List<Comic>
}

class CharacterDetalUseCaseImpl(
    private val characterDetailRepository: CharacterDetailRepository
) : CharacterDetailUseCase {

    override suspend fun getComicsForCharacter(id: Long, idComics: List<String>): List<Comic> =
        characterDetailRepository.getComicsForCharacter(id, idComics)
}