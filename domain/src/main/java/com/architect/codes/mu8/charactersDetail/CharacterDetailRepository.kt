package com.architect.codes.mu8.charactersDetail

import com.architect.codes.mu8.characters.Character

interface CharacterDetailRepository {
    suspend operator fun invoke(): Character
}