package com.architect.coders.mu8.characters.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.architect.coders.mu8.utils.ScopedViewModel
import com.architect.codes.mu8.characters.Character
import com.architect.codes.mu8.charactersDetail.CharacterDetailUseCase
import kotlinx.coroutines.launch
import java.io.IOException

class CharactersDetailViewModel(private val characterId: Long, private val characterDetailUseCase: CharacterDetailUseCase) :
    ScopedViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    private val _detailCharacter = MutableLiveData<Character>()
    val detailCharacter: LiveData<Character> get() = _detailCharacter

    init {
        getDetailCharacter()
    }

    private fun getDetailCharacter() {
        launch {
            _loading.value = true
            try {
                _detailCharacter.value = characterDetailUseCase.invoke(characterId)
                System.out.println(detailCharacter.value)
            } catch (e: IOException) {
                // _detailCharacter.value = In
            }
            _loading.value = false
        }
    }
}