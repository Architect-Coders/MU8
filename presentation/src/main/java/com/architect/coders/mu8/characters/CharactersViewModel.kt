package com.architect.coders.mu8.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.architect.coders.mu8.utils.Event
import com.architect.coders.mu8.utils.ScopedViewModel
import com.architect.codes.mu8.characters.Character
import com.architect.codes.mu8.characters.CharactersUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val charactersUseCase: CharactersUseCase,
    uiDispatcher: CoroutineDispatcher
) : ScopedViewModel(uiDispatcher) {

    private val _navigateToCharacter = MutableLiveData<Event<Long>>()
    val navigateToCharacter: LiveData<Event<Long>> get() = _navigateToCharacter

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    private val _characters = MutableLiveData<List<Character>>()
    val characters: LiveData<List<Character>> get() = _characters

    private val _title = MutableLiveData<String>()
    val title: LiveData<String> get() = _title

    fun getCharacters() {
        launch {
            _loading.value = true
            _characters.value = charactersUseCase()
            _loading.value = false
        }
    }

    fun onCharacterClicked(character: Character) {
        _navigateToCharacter.value = Event(character.id)
    }

    fun setTitle(toolbarTitle: String) {
        _title.value = toolbarTitle
    }
}
