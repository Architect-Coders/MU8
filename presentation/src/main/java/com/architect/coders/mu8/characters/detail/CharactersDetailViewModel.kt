package com.architect.coders.mu8.characters.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.architect.coders.mu8.utils.ScopedViewModel
import com.architect.codes.mu8.characters.Character
import com.architect.codes.mu8.characters.CharactersUseCase
import com.architect.codes.mu8.characters.detail.CharacterDetailUseCase
import com.architect.codes.mu8.comics.Comic
import com.architect.codes.mu8.utils.ERROR_INTERNET_MESSAGE
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import java.io.IOException

class CharactersDetailViewModel(
    private val characterDetailUseCase: CharacterDetailUseCase,
    private val charactersUseCase: CharactersUseCase,
    uiDispatcher: CoroutineDispatcher
) : ScopedViewModel(uiDispatcher) {

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    private val _character = MutableLiveData<Character>()
    val character: LiveData<Character> get() = _character

    private val _comicsForCharacter = MutableLiveData<List<Comic>>()
    val comicsForCharacter: LiveData<List<Comic>> get() = _comicsForCharacter

    private val _messageError = MutableLiveData<String>()
    val messageError: LiveData<String> get() = _messageError

    fun getDetailCharacter(characterId: Long) {
        launch {
            _loading.value = true
            try {
                _character.value = charactersUseCase.findCharacter(characterId)
                getComics()
            } catch (e: IOException) {
                _messageError.value = ERROR_INTERNET_MESSAGE
            }
            _loading.value = false
        }
    }

    private fun getComics() {
        launch {
            try {
                _character.value?.let {
                    _comicsForCharacter.value = characterDetailUseCase.getComicsForCharacter(it.id, it.comicIds)
                }
            } catch (e: IOException) {
                _messageError.value = ERROR_INTERNET_MESSAGE
            }
        }
    }
}