package com.architect.codes.mu8.characters

interface CharactersRepository {
    suspend operator fun invoke(): List<Character>
    suspend fun findCharacter(id: Long): Character
}
