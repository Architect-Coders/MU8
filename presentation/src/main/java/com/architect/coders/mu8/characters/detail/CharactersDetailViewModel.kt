package com.architect.coders.mu8.characters.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CharactersDetailViewModel() : ViewModel() {

    private val _model = MutableLiveData<CharactersDetailUiModel>()
    val model: LiveData<CharactersDetailUiModel>
        get() {
            return _model
        }
}