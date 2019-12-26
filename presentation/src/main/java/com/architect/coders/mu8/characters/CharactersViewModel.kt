package com.architect.coders.mu8.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.architect.coders.mu8.utils.ScopedViewModel
import com.architect.codes.mu8.characters.Character
import com.architect.codes.mu8.characters.CharactersUseCase
import kotlinx.coroutines.launch

class CharactersViewModel(private val charactersUseCase: CharactersUseCase) : ScopedViewModel() {

    private val _model = MutableLiveData<CharactersUiModel>()
    val model: LiveData<CharactersUiModel>
        get() {
            if (_model.value == null) getCharacters()
            return _model
        }

    private fun getCharacters() {
        launch {
            _model.value = CharactersUiModel.Loading
            _model.value = CharactersUiModel.Content(charactersUseCase())
        }
    }

    fun onCharacterClicked(character: Character) = Unit
}
