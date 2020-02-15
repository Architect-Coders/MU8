package com.architect.coders.mu8.characters.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.architect.coders.mu8.utils.ScopedViewModel
import com.architect.codes.mu8.characters.Character
import com.architect.codes.mu8.characters.CharactersUseCase
import com.architect.codes.mu8.charactersDetail.CharacterDetailUseCase
import com.architect.codes.mu8.comics.Comic
import kotlinx.coroutines.launch
import java.io.IOException

class CharactersDetailViewModel(private val characterId: Long,
                                private val characterDetailUseCase: CharacterDetailUseCase,
                                private val charactersUseCase: CharactersUseCase) :
    ScopedViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    private val _character = MutableLiveData<Character>()
    val character: LiveData<Character> get() = _character

    private val _comicsForCharacter = MutableLiveData<List<Comic>>()
    val comicsForCharacter: LiveData<List<Comic>> get() = _comicsForCharacter

    init {
        getDetailCharacter()
    }

    private fun getDetailCharacter() {
        launch {
            _loading.value = true
            try {
                _character.value = charactersUseCase.findCharacter(characterId)
                getComics()
            } catch (e: IOException) {
                // _detailCharacter.value = In
            }
            _loading.value = false
        }
    }

    private fun getComics() {
        launch {
            _character.value?.let {
                _comicsForCharacter.value = characterDetailUseCase.getComicsForCharacter(it.id, it.comicIds)
            }
            Log.i("tag", _comicsForCharacter.value.toString())
        }
    }
}