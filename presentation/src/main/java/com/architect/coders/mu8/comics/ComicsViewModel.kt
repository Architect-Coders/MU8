package com.architect.coders.mu8.comics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.architect.coders.mu8.comics.ComicsViewModel.UiModel.*
import com.architect.coders.mu8.utils.ScopedViewModel
import com.architect.codes.mu8.comics.ComicUseCase
import com.architect.codes.mu8.comics.Comic
import kotlinx.coroutines.launch
import java.io.IOException

class ComicsViewModel(private val useCase: ComicUseCase) : ScopedViewModel() {

    sealed class UiModel {
        object ShowLoading : UiModel()
        object InternetError : UiModel()
        class LoadData(val comics: List<Comic>) : UiModel()
        class NavigateTo(val comic: Comic) : UiModel()
    }

    private val _model = MutableLiveData<UiModel>()

    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) loadData()
            return _model
        }

    private fun loadData() {
        launch {
            _model.value = ShowLoading

            try {
                _model.value = LoadData(useCase())
            } catch (e: IOException) {
                _model.value = InternetError
            }
        }
    }

    fun onComicClicked(comic: Comic) {
        _model.value = NavigateTo(comic)
    }
}