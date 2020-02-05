package com.architect.coders.mu8.characters.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.architect.coders.mu8.utils.ScopedViewModel

class CharactersDetailViewModel(private val characterId: Long) : ScopedViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading


}