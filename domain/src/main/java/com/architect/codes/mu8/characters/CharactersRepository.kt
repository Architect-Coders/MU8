package com.architect.codes.mu8.characters

interface CharactersRepository {
    suspend operator fun invoke(): List<Character>
}
