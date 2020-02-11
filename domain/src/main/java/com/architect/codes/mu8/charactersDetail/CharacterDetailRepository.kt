package com.architect.codes.mu8.charactersDetail

import com.architect.codes.mu8.characters.Character

interface CharacterDetailRepository {

    suspend fun invoke(id: Long): Character
}