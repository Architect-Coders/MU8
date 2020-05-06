package com.architect.codes.mu8.characters.detail

import com.architect.codes.mu8.comics.Comic

interface CharacterDetailUseCase {
    suspend fun getComicsForCharacter(id: Long, idComics: List<String>): List<Comic>
}

class CharacterDetailUseCaseImpl(private val characterDetailRepository: CharacterDetailRepository) :
    CharacterDetailUseCase {

    override suspend fun getComicsForCharacter(id: Long, idComics: List<String>): List<Comic> {
        return characterDetailRepository.getComicsForCharacter(id, idComics)
    }
}
