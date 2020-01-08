package com.architect.coders.mu8.characters

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.architect.coders.mu8.utils.Event
import com.architect.coders.mu8.utils.ScopedViewModel
import com.architect.codes.mu8.characters.Character
import com.architect.codes.mu8.characters.CharactersUseCase
import kotlinx.coroutines.launch

class CharactersViewModel(private val charactersUseCase: CharactersUseCase) : ScopedViewModel() {

    private val _navigateToCharacter = MutableLiveData<Event<Long>>()
    val navigateToCharacter: LiveData<Event<Long>> get() = _navigateToCharacter

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    private val _characters = MutableLiveData<List<Character>>()
    val characters: LiveData<List<Character>> get() = _characters

    init {
        getCharacters()
    }

    private fun getCharacters() {
        launch {
            _loading.value = true
            _characters.value = charactersUseCase()
            _loading.value = false
        }
    }

    fun onCharacterClicked(character: Character) {
        _navigateToCharacter.value = Event(character.id)
    }
}
