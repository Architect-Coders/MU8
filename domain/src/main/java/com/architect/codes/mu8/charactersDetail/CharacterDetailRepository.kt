package com.architect.codes.mu8.charactersDetail

import com.architect.codes.mu8.comics.Comic

interface CharacterDetailRepository {

    suspend fun getComicsForCharacter(id: Long, idComics: List<String>): List<Comic>
}