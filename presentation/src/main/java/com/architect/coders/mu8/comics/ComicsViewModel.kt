package com.architect.coders.mu8.comics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.architect.coders.mu8.utils.Event
import com.architect.coders.mu8.utils.ScopedViewModel
import com.architect.codes.mu8.comics.ComicUseCase
import com.architect.codes.mu8.comics.Comic
import com.architect.codes.mu8.utils.ERROR_INTERNET_MESSAGE
import kotlinx.coroutines.launch
import java.io.IOException

class ComicsViewModel(private val useCase: ComicUseCase) : ScopedViewModel() {

    init {
        launch {
            _loading.value = true
            try {
                _comics.value = useCase()
            } catch (e: IOException) {
                _messageError.value = ERROR_INTERNET_MESSAGE
            }
            _loading.value = false
        }
    }

    private val _comics = MutableLiveData<List<Comic>>()
    val comics: LiveData<List<Comic>> get() = _comics

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    private val _navegateTo = MutableLiveData<Event<Comic>>()
    val navegateTo: LiveData<Event<Comic>> get() = _navegateTo

    private val _messageError = MutableLiveData<String>()
    val messageError : LiveData<String> get() = _messageError

    fun onComicClicked(comic: Comic) {
        _navegateTo.value = Event(comic)
    }
}
