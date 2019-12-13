package com.architect.coders.mu8.characters

import com.architect.codes.mu8.characters.Character

sealed class CharactersUiModel {
    object Loading : CharactersUiModel()
    class Content(val characters: List<Character>) : CharactersUiModel()
    class Navigation(val character: Character) : CharactersUiModel()
}
